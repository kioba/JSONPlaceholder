package io.github.kioba.jsonplaceholder

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import io.github.kioba.core.execute
import io.github.kioba.feed.ComposeActivity
import io.github.kioba.feed.FeedFragment
import io.github.kioba.feed.MainNavigation

class MainActivity : AppCompatActivity(), MainNavigation {

  override fun navigateToDetails(sharedElement: Pair<View, String>, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
      .setReorderingAllowed(true)
      .replace(R.id.main_content, fragment)
      .addToBackStack(null)
      .addSharedElement(sharedElement.first, sharedElement.second)
      .commit()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    startActivity(Intent(this, ComposeActivity::class.java))

    setContentView(R.layout.activity_main)

    if (savedInstanceState == null) {
      supportFragmentManager.execute {
        replace(R.id.main_content, FeedFragment())
      }
    }
  }

}
