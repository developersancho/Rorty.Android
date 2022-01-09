pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "Rorty.Android"
include(
    ":presentation:composerorty",
    ":presentation:nativerorty",
    ":data:model",
    ":data:local",
    ":data:remote",
    ":data:repository",
    ":domain",
    ":libraries:framework",
    ":libraries:components",
    ":libraries:testutils"
)
