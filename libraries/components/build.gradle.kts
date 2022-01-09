import plugins.AndroidLibraryPlugin
import extensions.*

apply<AndroidLibraryPlugin>()

dependencies {
    implementation(project(Modules.Framework))
    testImplementation(project(Modules.TestUtils))

    implementation(Deps.AndroidX.AppCompat)
    implementation(Deps.AndroidX.CoreKtx)
    implementation(Deps.Coroutine.Core)
    implementation(Deps.Coroutine.Android)
    implementation(Deps.AndroidX.Material)
    implementation(Deps.AndroidX.ConstraintLayout)
    implementation(Deps.AndroidX.RecyclerView)
    implementation(Deps.AndroidX.Paging)


    testImplementation(Deps.Test.Junit)
    androidTestImplementation(Deps.Test.JunitExt)
    androidTestImplementation(Deps.Test.EspressoCore)
}