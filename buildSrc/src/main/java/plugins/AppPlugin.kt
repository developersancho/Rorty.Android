package plugins

import com.android.build.api.dsl.BuildType
import com.android.build.gradle.AppExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.applyPlugins()
        target.configureAndroid()
        target.applyDependencies()
    }

    private fun Project.applyPlugins() {
        plugins.apply(GradlePlugins.AndroidApplication)
        plugins.apply(GradlePlugins.KotlinAndroid)
        plugins.apply(GradlePlugins.KotlinKapt)
        plugins.apply(GradlePlugins.KotlinParcelize)
        plugins.apply(GradlePlugins.Hilt)
    }

    private fun Project.configureAndroid() = this.extensions.getByType(AppExtension::class).run {
        compileSdkVersion(Configs.CompileSdk)
        defaultConfig.apply {
            applicationId = Configs.Id
            minSdk = Configs.MinSdk
            targetSdk = Configs.TargetSdk
            versionCode = Configs.VersionCode
            versionName = Configs.VersionName
            multiDexEnabled = true
            vectorDrawables.useSupportLibrary = true
            testInstrumentationRunner = Configs.AndroidJunitRunner
        }

        compileOptions.apply {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        project.tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
                allWarningsAsErrors = true
                freeCompilerArgs = Configs.FreeCompilerArgs
            }
        }

        packagingOptions.apply {
            resources {
                setExcludes(
                    setOf(
                        "META-INF/metadata.kotlin_module",
                        "META-INF/metadata.jvm.kotlin_module",
                        "META-INF/AL2.0",
                        "META-INF/LGPL2.1",
                        "META-INF/MANIFEST.MF",
                        "META-INF/com.android.tools/proguard/coroutines.pro",
                        "META-INF/proguard/coroutines.pro"
                    )
                )
            }
        }

        buildFeatures.viewBinding = true

        buildTypes.apply {
            getByName("release") {
                isDebuggable = false
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
                buildConfigStringField("BASE_URL", Configs.Release.BaseUrl)
                buildConfigStringField("DB_NAME", Configs.Release.DbName)
            }
            getByName("debug") {
                isTestCoverageEnabled = true
                proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
                buildConfigStringField("BASE_URL", Configs.Debug.BaseUrl)
                buildConfigStringField("DB_NAME", Configs.Debug.DbName)
            }
        }
    }

    private fun BuildType.buildConfigStringField(name: String, value: String) {
        this.buildConfigField("String", name, "\"$value\"")
    }

    private fun Project.applyDependencies() {
        dependencies.apply {
            add("implementation", Deps.AndroidX.AppCompat)
            add("implementation", Deps.AndroidX.CoreKtx)
            add("implementation", Deps.AndroidX.Material)
            add("implementation", Deps.AndroidX.ConstraintLayout)

            add("implementation", Deps.Coroutine.Core)
            add("implementation", Deps.Coroutine.Android)

            add("implementation", Deps.Lifecycle.ViewModel)
            add("implementation", Deps.Lifecycle.Runtime)
            add("implementation", Deps.Lifecycle.LiveData)

            add("implementation", Deps.Hilt.Android)
            add("kapt", Deps.Hilt.AndroidCompiler)

            add("implementation", Deps.AndroidX.ActivityKtx)
            add("implementation", Deps.AndroidX.FragmentKtx)

            add("implementation", Deps.Timber)
            add("implementation", Deps.Coil)
            add("implementation", Deps.AndroidX.Paging)
            add("implementation", Deps.AndroidX.SwipeRefreshLayout)

            add("testImplementation", Deps.Test.Junit)
            add("androidTestImplementation", Deps.Test.JunitExt)
            add("androidTestImplementation", Deps.Test.EspressoCore)
        }
    }
}