object Deps {

    object Compose {
        const val Ui = "androidx.compose.ui:ui:${Versions.Compose}"
        const val Material = "androidx.compose.material:material:${Versions.Compose}"
        const val UiPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose}"
        const val Activity = "androidx.activity:activity-compose:${Versions.ComposeActivity}"
        const val Junit4 = "androidx.compose.ui:ui-test-junit4:${Versions.Compose}"
        const val UiTooling = "androidx.compose.ui:ui-tooling:${Versions.Compose}"
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Lifecycle}"
    }

    object AndroidX {
        const val CoreKtx = "androidx.core:core-ktx:${Versions.CoreKtx}"
        const val AppCompat = "androidx.appcompat:appcompat:${Versions.AppCompat}"
        const val Material = "com.google.android.material:material:${Versions.Material}"
        const val ConstraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.ConstraintLayout}"
        const val RecyclerView = "androidx.recyclerview:recyclerview:${Versions.RecyclerView}"
        const val SwipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SwipeRefreshLayout}"
        const val ActivityKtx = "androidx.activity:activity-ktx:${Versions.ActivityKtx}"
        const val FragmentKtx = "androidx.fragment:fragment-ktx:${Versions.FragmentKtx}"
        const val Paging = "androidx.paging:paging-runtime-ktx:${Versions.Paging}"
    }

    object Lifecycle {
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle}"
        const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Lifecycle}"
        const val Runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Lifecycle}"
    }

    object Coroutine {
        const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutine}"
        const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutine}"
    }

    object Hilt {
        const val Android = "com.google.dagger:hilt-android:${Versions.Hilt}"
        const val AndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Hilt}"
    }

    object Moshi {
        const val Kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.Moshi}"
        const val Codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.Moshi}"
        const val LazyAdapter = "com.serjltt.moshi:moshi-lazy-adapters:${Versions.MoshiLazy}"
    }

    object Retrofit {
        const val Base = "com.squareup.retrofit2:retrofit:${Versions.Retrofit}"
        const val Moshi = "com.squareup.retrofit2:converter-moshi:${Versions.Retrofit}"
    }

    object Chucker {
        const val Library = "com.github.chuckerteam.chucker:library:${Versions.Chucker}"
        const val NoLibrary = "com.github.chuckerteam.chucker:library-no-op:${Versions.Chucker}"
    }

    object Okhttp {
        const val Base = "com.squareup.okhttp3:okhttp:${Versions.Okhttp}"
        const val LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Okhttp}"
    }

    object Room {
        const val Base = "androidx.room:room-ktx:${Versions.Room}"
        const val Compiler = "androidx.room:room-compiler:${Versions.Room}"
    }

    object CodeQuality {
        const val DETEKT_FORMATTER =
            "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.DETEKT}"
    }

    object Test {
        const val Junit = "junit:junit:${Versions.Junit}"
        const val JunitExt = "androidx.test.ext:junit:${Versions.JunitExt}"
        const val EspressoCore = "androidx.test.espresso:espresso-core:${Versions.EspressoCore}"
        const val Coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Coroutine}"
        const val Robolectric = "org.robolectric:robolectric:${Versions.Robolectric}"
        const val Mockk = "io.mockk:mockk:${Versions.Mockk}"
        const val Assertj = "org.assertj:assertj-core:${Versions.Assertj}"
        const val Room = "androidx.room:room-testing:${Versions.Room}"
        const val TestCore = "androidx.test:core:${Versions.Test}"
        const val TestRunner = "androidx.test:runner:${Versions.Test}"
        const val TestRules = "androidx.test:rules:${Versions.Test}"
        const val Hamcrest = "org.hamcrest:hamcrest-library:${Versions.Hamcrest}"
        const val Json = "org.json:json:${Versions.Json}"
        const val Okhttp = "com.squareup.okhttp3:mockwebserver:${Versions.Okhttp}"
        const val Turbine = "app.cash.turbine:turbine:${Versions.Turbine}"
        const val Fragment = "androidx.fragment:fragment-testing:${Versions.FragmentTest}"
        const val Truth = "com.google.truth:truth:${Versions.Truth}"
        const val Jupiter = "org.junit.jupiter:junit-jupiter-api:${Versions.Jupiter}"
        const val LiveData = "androidx.arch.core:core-testing:${Versions.Arch}"
    }

    const val Coil = "io.coil-kt:coil:${Versions.Coil}"
    const val Timber = "com.jakewharton.timber:timber:${Versions.Timber}"
    const val SecurityCrypto = "androidx.security:security-crypto-ktx:${Versions.SecurityCrypto}"
}