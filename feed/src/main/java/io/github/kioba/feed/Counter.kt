package io.github.kioba.feed

import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.Recompose
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.Expanded
import androidx.ui.layout.MainAxisAlignment.Center
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview

@Model
class Modal(
  var text: String = "Counter",
  var amount: Int = 0
)

@Composable
fun counterSample() =
  MaterialTheme {
    val state = Modal()
    Surface {
      Recompose { recompose ->
        Column(
          Expanded,
          mainAxisAlignment = Center,
          crossAxisAlignment = CrossAxisAlignment.Center
        ) {
          Text(text = "${state.text} ${state.amount}", modifier = Spacing(all = 16.dp))
          Button("Increment", { state.amount++; recompose() })
        }
      }
    }
  }


@Preview
@Composable
fun Preview() {
  counterSample()
}