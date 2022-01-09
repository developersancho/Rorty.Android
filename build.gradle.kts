plugins {
    id(GradlePlugins.VersionCheck)
    id(GradlePlugins.CodeAnalyze)
    id(GradlePlugins.TasksTest)
}

tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.BIN
    gradleVersion = "7.3.3"
}

/**
 *  commented for spotless plugin
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
*/