plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-kapt")
  id("kotlin-android-extensions")
}
apply(from = "../buildSrc/android.kts")

val compose_version = "0.1.0-dev02"

dependencies {

  fun List<DependencyType>.forDependendency() = forEach {
    when (it) {
      is Implementation -> implementation(it.lib)
      is Kapt -> kapt(it.lib)
    }
  }

  Dependencies.compose.forDependendency()

  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

  implementation(project(":core"))
  implementation(project(":placeholder"))
  implementation(project(":detail"))

  Dependencies.standard.forEach { implementation(it) }
  Dependencies.standardKapt.forEach { kapt(it) }

  Dependencies.testStandard.forEach { testImplementation(it) }
  Dependencies.testAndroidStandard.forEach { androidTestImplementation(it) }

  Dependencies.compose.forDependendency()

  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.60-eap-25")
}


