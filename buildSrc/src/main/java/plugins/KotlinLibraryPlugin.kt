package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.applyPlugins()
    }

    private fun Project.applyPlugins() {
        plugins.apply(GradlePlugins.KotlinLibrary)
    }
}