import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val appcompat: String = "1.1.0-alpha05"

    const val constraintlayout: String = "2.0.0-beta1"

    const val core_ktx: String = "1.0.2"

    const val androidx_lifecycle: String = "2.0.0"

    const val recyclerview: String = "1.1.0-alpha05"

    const val androidx_room: String = "2.1.0"

    const val espresso_core: String = "3.2.0"

    const val androidx_test_ext_junit: String = "1.1.1"

    const val androidx_test_core: String = "1.2.0"

    const val androidx_test_runner: String = "1.2.0"

    const val com_android_tools_build_gradle: String = "3.4.2"

    const val lint_gradle: String = "26.4.2"

    const val material: String = "1.0.0"

    const val gson: String = "2.8.5"

    const val com_google_dagger: String = "2.23.2"

    const val retrofit2_rxjava2_adapter: String = "1.0.0"

    const val com_jakewharton_rxbinding3: String = "3.0.0-alpha2"

    const val rxrelay: String = "2.1.0"

    const val logging_interceptor: String = "4.0.1"

    const val picasso: String = "2.71828"

    const val com_squareup_retrofit2: String = "2.6.0"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2"

    const val io_arrow_kt: String = "0.9.0"

    const val mockk: String = "1.9.3"

    const val rxandroid: String = "2.1.1"

    const val rxjava: String = "2.2.10"

    const val junit_junit: String = "4.12"

    const val org_jacoco: String = "0.7.9"

    const val compose_version: String = "0.1.0-dev02"
//    const val org_jetbrains_kotlin: String = "1.3.60-eap-25"

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.1.1"

        const val currentVersion: String = "5.5.1"

        const val nightlyVersion: String = "5.6-20190715221920+0000"

        const val releaseCandidate: String = ""
    }
}
