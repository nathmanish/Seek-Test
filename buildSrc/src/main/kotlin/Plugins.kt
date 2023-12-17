import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec

/**
 * Plugins
 */

fun PluginDependenciesSpec.pluginAndroidApplication(apply: Boolean = true) {
    id("com.android.application") version (VERSION_AGP) apply (apply)
}

fun PluginDependenciesSpec.pluginAndroidKotlin(apply: Boolean = true) {
    id("org.jetbrains.kotlin.android") version (VERSION_KOTLIN) apply (apply)
}

fun PluginDependenciesSpec.pluginLibrary() {
    id("com.android.library")
}

fun PluginDependenciesSpec.pluginApollo() {
    id("com.apollographql.apollo3").version(VERSION_APOLLO_PLUGIN)
}

fun PluginDependenciesSpec.pluginDaggerHilt(apply: Boolean = true) {
    id("com.google.dagger.hilt.android") version (HILT_VERSION) apply (apply)
}