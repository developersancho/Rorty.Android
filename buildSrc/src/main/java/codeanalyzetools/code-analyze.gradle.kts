package codeanalyzetools

plugins {
    id("codeanalyzetools.ktlint")
    id("codeanalyzetools.spotless")
    id("codeanalyzetools.detekt")
}

tasks.getByName("check") {
    setDependsOn(
        listOf(
            tasks.getByName("ktlintFormat"),
            tasks.getByName("spotlessApply"),

            tasks.getByName("ktlintCheck"),
            tasks.getByName("spotlessCheck"),
            tasks.getByName("detekt")
        )
    )
}

//project.afterEvaluate {
//
//    tasks.create("codeAnalyze") {
//        dependsOn("app:ktlintFormat")
//        dependsOn("data:ktlintFormat")
//        dependsOn("domain:ktlintFormat")
//
//        dependsOn("app:spotlessApply")
//        dependsOn("data:spotlessApply")
//        dependsOn("domain:spotlessApply")
//
//        dependsOn("app:testDebugUnitTest")
//        dependsOn("app:ktlintCheck")
//        dependsOn("app:spotlessCheck")
//        dependsOn("app:detekt")
//
//        dependsOn("data:testDebugUnitTest")
//        dependsOn("data:ktlintCheck")
//        dependsOn("data:spotlessCheck")
//        dependsOn("data:detekt")
//
//        dependsOn("domain:testDebugUnitTest")
//        dependsOn("domain:ktlintCheck")
//        dependsOn("domain:spotlessCheck")
//        dependsOn("domain:detekt")
//    }
//}

