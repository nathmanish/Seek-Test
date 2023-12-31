import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Dependencies
 */

fun DependencyHandler.implementCoreKtx() {
    implementation(CORE_KTX)
}

fun DependencyHandler.implementAppCompat() {
    implementation(APP_COMPAT)
}

fun DependencyHandler.implementAndroidMaterial() {
    implementation(ANDROID_MATERIAL)
}

fun DependencyHandler.implementAndroidLifeCycleKtx() {
    implementation(ANDROID_LIFE_CYCLE_KTX)
}

fun DependencyHandler.implementAndroidCompose() {
    implementation(ANDROID_COMPOSE)
}

fun DependencyHandler.implementComposeBom() {
    implementationPlatform(ANDROID_COMPOSE_BOM)
}

fun DependencyHandler.implementComposeUI() {
    implementation(ANDROID_COMPOSE_UI)
}

fun DependencyHandler.implementComposeGraphics() {
    implementation(ANDROID_COMPOSE_GRAPHICS)
}

fun DependencyHandler.implementComposeToolingPreview() {
    implementation(ANDROID_COMPOSE_TOOLING_PREVIEW)
}

fun DependencyHandler.implementComposeMaterial3() {
    implementation(ANDROID_COMPOSE_MATERIAL3)
}

fun DependencyHandler.implementSDPCompose() {
    implementation(COMPOSE_SDP)
}

fun DependencyHandler.implementPagingRuntime() {
    implementation(PAGING_RUNTIME)
}

fun DependencyHandler.implementComposePaging() {
    implementation(PAGING_COMPOSE)
}

fun DependencyHandler.implementViewModelCompose() {
    implementation(VIEW_MODEL_COMPOSE)
}

fun DependencyHandler.implementSwipeRefreshCompose() {
    implementation(SWIPE_REFRESH)
}

fun DependencyHandler.implementComposeNavigation() {
    implementation(COMPOSE_NAVIGATION)
}

fun DependencyHandler.implementOkhttpInterceptor() {
    implementation(OK_HTTP_INTERCEPTOR)
}

fun DependencyHandler.testImplementationJUnit() {
    testImplementation(TEST_JUNIT)
}

fun DependencyHandler.testImplementationCoreTesting() {
    testImplementation(CORE_TESTING)
}

fun DependencyHandler.testImplementationCoroutineTesting() {
    testImplementation(COROUTINE_TESTING)
}

fun DependencyHandler.testImplementationMockitoCore() {
    testImplementation(MOCKITO_CORE)
}

fun DependencyHandler.testImplementationMockitoInline() {
    testImplementation(MOCKITO_INLINE)
}

fun DependencyHandler.testImplementationMockitoKotlin() {
    testImplementation(MOCKITO_KOTLIN)
}

fun DependencyHandler.androidTestImplementationExtJUnit() {
    androidTestImplementation(TEST_ANDROID_EXT_JUNIT)
}

fun DependencyHandler.androidTestImplementationEspressoCore() {
    androidTestImplementation(TEST_ANDROID_ESPRESSO_CORE)
}

fun DependencyHandler.androidTestImplementationPlatformComposeBom() {
    implementationPlatform(TEST_ANDROID_COMPOSE_BOM)
}

fun DependencyHandler.androidTestImplementationComposeUITestJunit() {
    androidTestImplementation(TEST_COMPOSE_UI_TEST_JUNIT)
}

fun DependencyHandler.debugImplementationComposeUITooling() {
    debugImplementation(COMPOSE_UI_TOOLING)
}

fun DependencyHandler.debugImplementationComposeUITestManifest() {
    debugImplementation(COMPOSE_UI_TEST_MANIFEST)
}

fun DependencyHandler.addCoreModule() {
    implementationProject(CORE_MODULE)
}

fun DependencyHandler.addApolloApi() {
    api(ANDROID_APOLLO)
}

fun DependencyHandler.addDaggerHilt() {
    implementation(DAGGER_HILT)
}

fun DependencyHandler.addDaggerHiltKapt() {
    kapt(DAGGER_KAPT_HILT)
}