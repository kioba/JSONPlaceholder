package io.github.kioba.feed

import androidx.annotation.CheckResult
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.effectOf
import androidx.compose.memo
import androidx.compose.onActive
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.core.content.ContextCompat
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Dp
import androidx.ui.core.LayoutModifier
import androidx.ui.core.Text
import androidx.ui.core.WithDensity
import androidx.ui.core.dp
import androidx.ui.core.sp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.ExpandedWidth
import androidx.ui.layout.LayoutSize.Expand
import androidx.ui.layout.Row
import androidx.ui.layout.Spacing
import androidx.ui.layout.WidthSpacer
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeTextStyle
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow.Ellipsis
import arrow.core.Option.Companion.empty
import arrow.core.some
import io.github.kioba.feed.R.color
import io.github.kioba.feed.mvi_models.CombinedFeed
import io.github.kioba.feed.mvi_models.FeedState
import io.github.kioba.feed.mvi_models.InitialFeedIntent
import io.github.kioba.placeholder.user.User
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers

@Composable
fun FeedCompose(viewModel: IFeedViewModel) {

  var feedState by +state { empty<FeedState>() }
  +onActive {
    val rxDisposable = viewModel.state()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({ feedState = it.some() }, {})
    viewModel.bind(Flowable.just(InitialFeedIntent))
    onDispose { rxDisposable.dispose() }
  }

  VerticalScroller {
    Column(crossAxisSize = Expand) {
      feedState.fold({}, { fState ->
        fState.combined.forEach {
          FeedCard(it)
        }
      })
    }
  }
}

@Composable
private fun FeedCard(combined: CombinedFeed) {
  Container(modifier = Spacing(horizontal = 8.dp, vertical = 4.dp)) {
    Card(elevation = 2.dp) {
      Column(modifier = Spacing(all = 8.dp)) {
        Row {
          WidthSpacer(width = 64.dp)
          combined.user.fold(
            {},
            { UserText(it) })
        }
        Row(mainAxisSize = Expand) {
          VectorImage(R.drawable.ic_baseline_face_64)

          Column(modifier = Flexible(1f), crossAxisSize = Expand) {
            TitleText(combined.post.title)
            DescriptionText(combined)
          }
        }
      }
    }
  }
}

@Composable
fun VectorImage(@DrawableRes id: Int, tint: Color = Color.Transparent) {
  val vector = +vectorResource(id)
  WithDensity {
    Container(
      width = vector.defaultWidth.toDp(),
      height = vector.defaultHeight.toDp()
    ) {
      DrawVector(vector, tint)
    }
  }
}

@Composable
private fun DescriptionText(combined: CombinedFeed) {
  Text(
    text = combined.post.body,
    style = +themeTextStyle { body2 }
  )
}

@Composable
private fun TitleText(title: String) {
  Text(
    text = title,
    overflow = Ellipsis,
    modifier = Spacing(vertical = 2.dp).wraps(ExpandedWidth),
    style = +themeTextStyle { h6 })
}

@Composable
private fun UserText(it: User) {
  val color = +colorResource(color.fadedTitleTextColor)
  Text(
    text = "${it.name} @${it.username}",
    maxLines = 1,
    style = +themeTextStyle {
      overline
        .merge(TextStyle(fontSize = 12.sp, color = color))
    }
  )
}

@CheckResult(suggest = "+")
fun colorResource(@ColorRes resId: Int) = effectOf<Color> {
  val context = +ambient(ContextAmbient)
  +memo(resId) {
    Color(ContextCompat.getColor(context, resId))
  }
}

typealias compose = () -> Unit

fun Spacing(vertical: Dp = 0.dp, horizontal: Dp = 0.dp): LayoutModifier =
  Spacing(left = horizontal, top = vertical, right = horizontal, bottom = vertical)

@Composable
fun App(child: @Composable compose) {
  MaterialTheme {
    Surface {
      child()
    }
  }
}