import plugins.AndroidLibraryPlugin
import extensions.*

apply<AndroidLibraryPlugin>()
apply(plugin = GradlePlugins.Hilt)

dependencies {
    implementation(project(Modules.Model))
    implementation(project(Modules.Local))
    implementation(project(Modules.Remote))
    implementation(project(Modules.Repository))
    implementation(project(Modules.Framework))
    testImplementation(project(Modules.TestUtils))

    implementation(Deps.Hilt.Android)
    kapt(Deps.Hilt.AndroidCompiler)

    implementation(Deps.AndroidX.Paging)

    implementation(Deps.Coroutine.Core)
    implementation(Deps.Coroutine.Android)

    testImplementation(Deps.Test.Junit)
    androidTestImplementation(Deps.Test.JunitExt)
    androidTestImplementation(Deps.Test.EspressoCore)
}