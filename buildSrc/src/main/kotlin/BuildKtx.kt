import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

fun DependencyHandler.implementationPlatform(dependency: String) {
    add("implementation", platform(dependency))
}

fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

fun DependencyHandler.androidTestImplementation(dependency: String) {
    add("androidTestImplementation", dependency)
}

fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation", dependency)
}

fun DependencyHandler.implementationProject(dependency: String) {
    add("implementation", project(dependency))
}

fun DependencyHandler.api(dependency: String) {
    add("api", dependency)
}

fun DependencyHandler.kapt(dependency: String) {
    add("kapt", dependency)
}