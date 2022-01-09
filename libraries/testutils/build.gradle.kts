import plugins.AndroidLibraryPlugin
import extensions.*

apply<AndroidLibraryPlugin>()

dependencies {
    implementation(Deps.AndroidX.AppCompat)
    implementation(Deps.Moshi.Kotlin)
    implementation(Deps.Retrofit.Base)
    implementation(Deps.Retrofit.Moshi)
    implementation(Deps.Okhttp.LoggingInterceptor)
    api(Deps.Test.Coroutine)
    api(Deps.Test.Robolectric)
    api(Deps.Test.Mockk)
    api(Deps.Test.Assertj)
    api(Deps.Test.Room)
    api(Deps.Test.TestCore)
    api(Deps.Test.TestRunner)
    api(Deps.Test.TestRules)
    api(Deps.Test.Hamcrest)
    api(Deps.Test.Json)
    api(Deps.Test.Okhttp)
    api(Deps.Test.Turbine)
    api(Deps.Test.Fragment)
    api(Deps.Test.Truth)
    api(Deps.Test.Jupiter)
}