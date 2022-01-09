import plugins.AndroidLibraryPlugin
import extensions.*

apply<AndroidLibraryPlugin>()

dependencies {
    testImplementation(project(Modules.TestUtils))

    implementation(Deps.AndroidX.AppCompat)
    implementation(Deps.AndroidX.CoreKtx)
    implementation(Deps.Coroutine.Core)
    implementation(Deps.Coroutine.Android)
    implementation(Deps.AndroidX.Material)
    implementation(Deps.AndroidX.ConstraintLayout)
    implementation(Deps.AndroidX.RecyclerView)
    implementation(Deps.AndroidX.Paging)

    implementation(Deps.Lifecycle.ViewModel)
    implementation(Deps.Lifecycle.Runtime)
    implementation(Deps.Moshi.Kotlin)
    implementation(Deps.Timber)
    implementation(Deps.Retrofit.Base)
    implementation(Deps.SecurityCrypto)
    implementation(Deps.Room.Base)

    testImplementation(Deps.Test.Junit)
    androidTestImplementation(Deps.Test.JunitExt)
    androidTestImplementation(Deps.Test.EspressoCore)
}