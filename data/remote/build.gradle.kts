import plugins.AndroidLibraryPlugin
import extensions.*

apply<AndroidLibraryPlugin>()
apply(plugin = GradlePlugins.Hilt)

dependencies {
    implementation(project(Modules.Model))
    implementation(project(Modules.Framework))
    testImplementation(project(Modules.TestUtils))

    implementation(Deps.Retrofit.Base)
    implementation(Deps.Retrofit.Moshi)
    implementation(Deps.Okhttp.Base)
    implementation(Deps.Okhttp.LoggingInterceptor)
    debugImplementation(Deps.Chucker.Library)
    releaseImplementation(Deps.Chucker.NoLibrary)

    implementation(Deps.Hilt.Android)
    kapt(Deps.Hilt.AndroidCompiler)

    testImplementation(Deps.Test.Junit)
    androidTestImplementation(Deps.Test.JunitExt)
    androidTestImplementation(Deps.Test.EspressoCore)
}