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