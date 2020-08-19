android {
  compileSdkVersion(AndroidVersions.targetSDK)
  defaultConfig {
    minSdkVersion(AndroidVersions.minSDK)
    targetSdkVersion(AndroidVersions.targetSDK)
    versionCode = AndroidVersions.versionCode
    versionName = AndroidVersions.versionName
  }
  buildTypes {
    getByName("release") {
      minifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }

    getByName("debug") {
      testCoverageEnabled = true
    }
  }
//  buildFeatures {
//    // Enables Jetpack Compose for this module
//    compose = true
//  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = '1.8'
  }

  testOptions {
    unitTests {
      all {
        testLogging {
          events("passed", "skipped", "failed")
        }
      }
    }
  }
}
