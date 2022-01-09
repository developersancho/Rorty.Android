import plugins.AndroidLibraryPlugin
import extensions.*

apply<AndroidLibraryPlugin>()

dependencies {
    implementation(project(Modules.Framework))
    testImplementation(project(Modules.TestUtils))

    implementation(Deps.Room.Base)
    kapt(Deps.Room.Compiler)
    implementation(Deps.Moshi.Kotlin)
    implementation(Deps.Moshi.LazyAdapter)

    testImplementation(Deps.Test.Junit)
    androidTestImplementation(Deps.Test.JunitExt)
    androidTestImplementation(Deps.Test.EspressoCore)
}