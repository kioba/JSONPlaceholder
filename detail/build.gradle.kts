plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-kapt")
  id("kotlin-android-extensions")
}

apply(from = "../buildSrc/android.kts")

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

  implementation(project(":core"))
  implementation(project(":placeholder"))

  Dependencies.standard.forEach { implementation(it) }
  Dependencies.standardKapt.forEach { kapt(it) }

  Dependencies.testStandard.forEach { testImplementation(it) }
  Dependencies.testAndroidStandard.forEach { androidTestImplementation(it) }

  fun List<DependencyType>.forDependendency() = forEach {
    when (it) {
      is Implementation -> implementation(it.lib)
      is Kapt -> kapt(it.lib)
    }
  }
  Dependencies.compose.forDependendency()
}
