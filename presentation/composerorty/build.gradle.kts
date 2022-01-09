import extensions.*
import plugins.AppComposePlugin

apply<AppComposePlugin>()

dependencies {
    implementation(project(Modules.Model))
    implementation(project(Modules.Local))
    implementation(project(Modules.Remote))
    implementation(project(Modules.Repository))
    implementation(project(Modules.Domain))
    implementation(project(Modules.Framework))
    implementation(project(Modules.Components))
    testImplementation(project(Modules.TestUtils))
}