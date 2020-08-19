package io.github.kioba.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.layout.ExpandedWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Spacing
import androidx.ui.layout.WidthSpacer
import androidx.ui.material.themeTextStyle
import androidx.ui.tooling.preview.Preview
import dagger.android.AndroidInjection
import javax.inject.Inject


class ComposeActivity : AppCompatActivity() {

  @Inject
  lateinit var viewModel: IFeedViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContent {
      App {
        FeedCompose(viewModel)
      }
    }
  }
}

@Preview
@Composable
fun myPreview() {
  App {
    Row {
      WidthSpacer(width = 64.dp)
      Column(modifier = Flexible(1f, tight = false)) {
        Text(
          text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
          modifier = Spacing(all = 8.dp),
          style = +themeTextStyle { h6 })
        Text(text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        Text(text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
      }
    }
  }
}