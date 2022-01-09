import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(GradlePlugins.VersionCheck)
    id(GradlePlugins.CodeAnalyze)
    id(GradlePlugins.TasksTest)
}

tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.BIN
    gradleVersion = "7.3.3"
}

tasks.withType(KotlinCompile::class.java).configureEach {
    kotlinOptions {
        allWarningsAsErrors = false
        freeCompilerArgs = Configs.FreeCompilerArgs
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

/*
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
*/