package io.github.kioba.detail

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import arrow.core.toOption
import dagger.android.support.AndroidSupportInjection
import io.github.kioba.core.gone
import io.github.kioba.core.registerForDispose
import io.github.kioba.core.show
import io.github.kioba.detail.mvi_models.DetailIntent
import io.github.kioba.detail.mvi_models.DetailViewState
import io.github.kioba.detail.mvi_models.InitialDetailIntent
import io.github.kioba.placeholder.json_placeholder.network_models.Post
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject


class DetailFragment : Fragment() {

  private val adapter = DetailAdapter()

  private val disposables = CompositeDisposable()

  @Inject
  lateinit var viewModel: IDetailViewModel

  lateinit var loadingDrawable: ColorDrawable

  override fun onAttach(context: Context) {
    super.onAttach(context)
    AndroidSupportInjection.inject(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View = inflater.inflate(R.layout.fragment_detail, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    detail_recycler.layoutManager = LinearLayoutManager(requireContext())
    detail_recycler.adapter = adapter

    detail_content.alpha = 0f
    ObjectAnimator.ofFloat(detail_content, View.ALPHA, 0f, 1f).apply {
      startDelay = 150
      duration = 850
      start()
    }

    loadingDrawable =
      ColorDrawable(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))
  }

  override fun onStart() {
    super.onStart()

    viewModel.state()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(this::render, this::streamError)
      .registerForDispose(disposables)
    viewModel.bind(intents(arguments!!.toPost()))

  }

  override fun onStop() {
    super.onStop()

    disposables.clear()
  }


  /**
   * DetailIntent events generated from the View
   * @return stream of view intents
   */
  private fun intents(post: Post): Flowable<DetailIntent> = Flowable.just(InitialDetailIntent(post))

  /**
   * rendering function for the viewState
   * @param state: view state
   */
  private fun render(state: DetailViewState) {
    state.post.toOption().fold(
      ifEmpty = {},
      ifSome = {
        detail_title.text = it.title
        detail_body.text = it.body
      }
    )


    when {
      state.isUserLoading -> {
        detail_user_name.show()
        detail_user_name.background = loadingDrawable
        detail_avatar.setImageDrawable(loadingDrawable)
      }
      state.userError != null -> {
        detail_user_name.gone()
      }
      state.user != null -> {
        detail_user_name.show()
        detail_user_name.background = null
        detail_user_name.text = "%s %s".format(state.user.name, state.user.username)
      }
    }

    when {
      state.isCommentsLoading -> {
      }
      state.commentError != null -> {
      }
      else -> {

      }
    }
  }

  /**
   * report stream errors for crashlytics
   * @param error: ErrorType which have been triggered inside the stream
   */
  private fun streamError(error: Throwable) {
    throw error
  }

  companion object {
    private const val bodyDescription = "detailBodyDescription"
    private const val idDescription = "detailIdDescription"
    private const val userIdDescription = "detailUserIdDescription"
    private const val titleDescription = "detailTitleDescription"

    fun post(post: Post): DetailFragment = DetailFragment().apply {
      arguments = Bundle().putPost(post)
    }

    private fun Bundle.putPost(post: Post) = this.apply {
      putString(bodyDescription, post.body)
      putInt(idDescription, post.id)
      putInt(userIdDescription, post.userId)
      putString(titleDescription, post.title)
    }

    private fun Bundle.toPost(): Post = Post(
      body = getString(bodyDescription)!!,
      id = getInt(idDescription),
      userId = getInt(userIdDescription),
      title = getString(titleDescription)!!
    )
  }
}

