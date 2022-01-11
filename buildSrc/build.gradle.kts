plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

gradlePlugin {
    plugins {
        register("AppPlugin") {
            id = "AppPlugin"
            implementationClass = "plugins.AppPlugin"
        }
        register("AndroidLibraryPlugin") {
            id = "AndroidLibraryPlugin"
            implementationClass = "plugins.AndroidLibraryPlugin"
        }
        register("KotlinLibraryPlugin") {
            id = "KotlinLibraryPlugin"
            implementationClass = "plugins.KotlinLibraryPlugin"
        }
    }
}

object Versions {
    const val GRADLE = "7.1.0-rc01"
    const val KOTLIN = "1.6.10"
    const val HILT = "2.40.5"
    const val VERSION_CHECKER = "0.39.0"
    const val KTLINT = "10.2.0"
    const val SPOTLESS = "6.0.0"
    const val DETEKT = "1.19.0"
    const val DOKKA = "1.6.0"
}

object Deps {
    const val ANDROID_GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val HILT_GRADLE = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
    const val VERSION_CHECKER = "com.github.ben-manes:gradle-versions-plugin:${Versions.VERSION_CHECKER}"
    const val KTLINT = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.KTLINT}"
    const val SPOTLESS = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.SPOTLESS}"
    const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.DETEKT}"
    const val DOKKA = "org.jetbrains.dokka:dokka-gradle-plugin:${Versions.DOKKA}"
}

dependencies {
    implementation(gradleApi())
    implementation(Deps.ANDROID_GRADLE)
    implementation(Deps.KOTLIN_GRADLE)
    implementation(Deps.HILT_GRADLE)
    implementation(Deps.VERSION_CHECKER)
    implementation(Deps.KTLINT)
    implementation(Deps.SPOTLESS)
    implementation(Deps.DETEKT)
    implementation(Deps.DOKKA)
}