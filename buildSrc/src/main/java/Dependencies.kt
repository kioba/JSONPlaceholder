object Version {

  const val kotlin = "1.3.51"

  // Unit Test
  const val mockK = "1.9"
  const val junit4 = "4.12"

  // Android Test
  const val test_runner = "1.1.1"
  const val androidXTest = "1.1.0"
  const val espresso = "3.1.1"

  // androidX
  const val androidXAppcompat = "1.1.0-alpha05"
  const val coreKtx = "1.0.2"

  // AndroidX material version
  const val material = "1.0.0"

  // AndroidX navigation version
  const val androidXNavigation = "1.0.0-alpha05"

  // androidX recyclerview version
  const val androidXRecyclerview = "1.1.0-alpha05"

  // androidX constraintLayout version
  const val constraintLayout = "1.1.3"
//  const val androidXConstraintLayout = "2.0.0-beta1"

  // androidX
  const val androidXLifecycle = "2.0.0"

  const val androidXRoom = "2.1.0-beta01"

  // Arrow
  const val arrow = "0.9.0"

  //RXJava
  const val rxjava = "2.2.7"
  const val rxandroid = "2.1.0"
  const val rxrelay = "2.1.0"
  const val rxbinding = "3.0.0-alpha2"

  // Dagger
  const val dagger = "2.22.1"

  //Networking
  const val retrofit = "2.4.0"
  const val rxjava2Adapter = "1.0.0"
  const val gsonConverter = "2.4.0"
  const val gson = "2.8.5"
  const val interceptor = "3.11.0"

  // Images
  const val picasso = "2.71828"

}

object Dependencies {
  //   kotlin
  private const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"

  //  AndroidX
  private const val androidXAppcompat = "androidx.appcompat:appcompat:${Version.androidXAppcompat}"
  private const val androidXCoreKtx = "androidx.core:core-ktx:${Version.coreKtx}"

  // androidX recyclerView
  private const val recyclerView =
    "androidx.recyclerview:recyclerview:${Version.androidXRecyclerview}"

  // androidX constraintLayout
  private const val constraintLayout =
    "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

  // androidX Architecture components
  private const val lifecycleExtensions =
    "androidx.lifecycle:lifecycle-extensions:${Version.androidXLifecycle}"
  private const val lifecycleViewModelKtx =
    "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.androidXLifecycle}" // use -ktx for Kotlin
  private const val lifecycleCompiler =
    "androidx.lifecycle:lifecycle-compiler:${Version.androidXLifecycle}"

  // androidX Room
  private const val roomRuntime = "androidx.room:room-runtime:${Version.androidXRoom}"
  private const val roomCompiler = "androidx.room:room-compiler:${Version.androidXRoom}"
  private const val roomRxjava2 = "androidx.room:room-rxjava2:${Version.androidXRoom}"
  private const val roomTesting = "androidx.room:room-testing:${Version.androidXRoom}"

  // androidX Navigation
  private const val navigationRuntime =
    "androidx.navigation:navigation-runtime:${Version.androidXNavigation}"
  private const val navigationRuntime_ktx =
    "androidx.navigation:navigation-runtime-ktx:${Version.androidXNavigation}"
  private const val navigationFragment =
    "androidx.navigation:navigation-fragment:${Version.androidXNavigation}"
  private const val navigationFragment_ktx =
    "androidx.navigation:navigation-fragment-ktx:${Version.androidXNavigation}"
  private const val navigationUi = "androidx.navigation:navigation-ui:${Version.androidXNavigation}"
  private const val navigationUi_ktx =
    "androidx.navigation:navigation-ui-ktx:${Version.androidXNavigation}"
  private const val navigationSafe_args_plugin =
    "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.androidXNavigation}"

  //  material
  private const val material = "com.google.android.material:material:${Version.material}"

  // Arrow
  private const val arrowCoreData = "io.arrow-kt:arrow-core-data:${Version.arrow}"
  private const val arrowCoreExtensions = "io.arrow-kt:arrow-core-extensions:${Version.arrow}"
  private const val arrowSyntax = "io.arrow-kt:arrow-syntax:${Version.arrow}"
  private const val arrowTypeclasses = "io.arrow-kt:arrow-typeclasses:${Version.arrow}"
  private const val arrowExtrasData = "io.arrow-kt:arrow-extras-data:${Version.arrow}"
  private const val arrowExtrasExtensions = "io.arrow-kt:arrow-extras-extensions:${Version.arrow}"

  private const val arrowEffectsData = "io.arrow-kt:arrow-effects-data:${Version.arrow}"
  private const val arrowEffectsExtensions = "io.arrow-kt:arrow-effects-extensions:${Version.arrow}"

  // RxJava2
  private const val rxjava = "io.reactivex.rxjava2:rxjava:${Version.rxjava}"
  private const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Version.rxandroid}"
  private const val rxrelay = "com.jakewharton.rxrelay2:rxrelay:${Version.rxrelay}"

  // RXBinding
  private const val rxbinding = "com.jakewharton.rxbinding3:rxbinding:${Version.rxbinding}"
  private const val rxbindingCore = "com.jakewharton.rxbinding3:rxbinding-core:${Version.rxbinding}"
  private const val rxbindingAppcompat =
    "com.jakewharton.rxbinding3:rxbinding-appcompat:${Version.rxbinding}"
  private const val rxbindingRecyclerview =
    "com.jakewharton.rxbinding3:rxbinding-recyclerview:${Version.rxbinding}"
  private const val rxbindingMaterial =
    "com.jakewharton.rxbinding3:rxbinding-material:${Version.rxbinding}"

  // Dagger
  private const val dagger = "com.google.dagger:dagger:${Version.dagger}"
  private const val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger}"
  private const val daggerAndroidSupport =
    "com.google.dagger:dagger-android-support:${Version.dagger}"

  private const val daggerCompoler = "com.google.dagger:dagger-compiler:${Version.dagger}"
  private const val daggerAndroidProcessor =
    "com.google.dagger:dagger-android-processor:${Version.dagger}"


  // Networking
  private const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
  private const val loggingInterceptor =
    "com.squareup.okhttp3:logging-interceptor:${Version.interceptor}"
  private const val gson = "com.google.code.gson:gson:${Version.gson}"
  private const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.gsonConverter}"
  private const val rxjava2Adapter =
    "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Version.rxjava2Adapter}"

  // Picasso
  private const val picasso = "com.squareup.picasso:picasso:${Version.picasso}"

  //  unit test
  private const val junit4 = "junit:junit:${Version.junit4}"
  private const val mockK = "io.mockk:mockk:${Version.mockK}"

  //  android test
  private const val androidXTestCore = "androidx.test:core:${Version.androidXTest}"
  private const val androidXTestJunit = "androidx.test.ext:junit:${Version.androidXTest}"
  private const val testRunner = "androidx.test:runner:${Version.test_runner}"
  private const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"


  val standardKapt: List<String> = listOf(
    lifecycleCompiler,
    daggerCompoler,
    daggerAndroidProcessor
  )

  val standard: List<String> = listOf(
//    kotlin_stdlib,
    androidXAppcompat,
    androidXCoreKtx,
    constraintLayout,
    material,
    lifecycleViewModelKtx,
    lifecycleExtensions,
    recyclerView,
    arrowCoreData,
    arrowCoreExtensions,
    arrowSyntax,
    arrowTypeclasses,
    arrowExtrasData,
    arrowExtrasExtensions,
    arrowEffectsData,
    arrowEffectsExtensions,
    rxjava,
    rxandroid,
    rxrelay,
    rxbinding,
    rxbindingCore,
    rxbindingAppcompat,
    rxbindingRecyclerview,
    rxbindingMaterial,
    dagger,
    daggerAndroid,
    daggerAndroidSupport,
    picasso
  )

  val testStandard: List<String> = listOf(junit4, mockK)

  val testAndroidStandard: List<String> =
    listOf(
      androidXTestCore,
      androidXTestJunit,
      testRunner,
      espresso
    )

  val networking: List<String> = listOf(
    retrofit,
    loggingInterceptor,
    gson,
    gsonConverter,
    rxjava2Adapter
  )

  val persistence: List<String> = listOf(
    roomRuntime,
    roomRxjava2
  )

  val persistenceKapt: List<String> = listOf(
    roomCompiler
  )
  val persistenceTest: List<String> = listOf(
    roomTesting
  )

  val compose: List<DependencyType> = listOf(
    Libs.compose_runtime.impl(),
    Libs.compose_compiler.kapt(),
    Libs.compose_layout.impl(),
    Libs.compose_core.impl(),
    Libs.compose_android_text.impl(),
    Libs.compose_framework.impl(),
    Libs.compose_tooling.impl(),
    Libs.compose_animation.impl(),
    Libs.compose_material.impl(),
    Libs.compose_text.impl()
  )

  private fun String.kapt() = Kapt(this)
  private fun String.impl() = Implementation(this)
}
