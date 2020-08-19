
sealed class DependencyType() { abstract val lib: String }
data class Implementation(override val lib: String): DependencyType()
data class Kapt(override val lib: String): DependencyType()