package io.github.kioba.feed

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.github.kioba.core.IActionProcessor
import io.github.kioba.core.ViewModelKey
import io.github.kioba.feed.mvi_models.FeedIntent
import io.github.kioba.feed.mvi_models.FeedResult

@Module(
  includes = [FeedModule.FeedProvider::class]
)
interface FeedModule {

  @ContributesAndroidInjector(modules = [(InjectViewModel::class)])
  fun bindFeedFragment(): FeedFragment

  @ContributesAndroidInjector(modules = [(InjectActivityViewModel::class)])
  fun bindComposeActivity(): ComposeActivity

  @Module
  class InjectViewModel {

    @Provides
    fun provideFeatureViewModel(
      factory: ViewModelProvider.Factory,
      target: FeedFragment
    ): IFeedViewModel =
      ViewModelProviders.of(
        target.activity as FragmentActivity,
        factory
      ).get(FeedViewModel::class.java)
  }

  @Module
  class InjectActivityViewModel {

    @Provides
    fun provideFeatureViewModel(
      factory: ViewModelProvider.Factory,
      target: ComposeActivity
    ): IFeedViewModel =
      ViewModelProviders.of(
        target,
        factory
      ).get(FeedViewModel::class.java)
  }

  @Module
  interface FeedProvider {

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    fun provideFeedViewModel(feedViewModel: FeedViewModel): ViewModel

    @Binds
    fun bindFeedActionProcessor(feedActionProcessor: FeedActionProcessor): IActionProcessor<FeedIntent, FeedResult>
  }

}
