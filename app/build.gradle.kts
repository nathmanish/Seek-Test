plugins {
    pluginAndroidApplication()
    pluginAndroidKotlin()
    pluginDaggerHilt()
    kotlin("kapt")
}

android {
    namespace = Config.APP_ID
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        applicationId = Config.APP_ID
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

        testInstrumentationRunner = Config.ANDROID_TEST_INSTRUMENTATION
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.JVM_TARGET
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.KOTLIN_COMPILE_VERSION
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementCoreKtx()
    implementAndroidLifeCycleKtx()
    implementAndroidCompose()
    implementComposeBom()
    implementComposeUI()
    implementComposeGraphics()
    implementComposeToolingPreview()
    implementComposeMaterial3()
    implementSDPCompose()
    implementPagingRuntime()
    implementComposePaging()
    implementViewModelCompose()
    implementSwipeRefreshCompose()
    addDaggerHilt()
    addDaggerHiltKapt()
    testImplementationJUnit()
    androidTestImplementationExtJUnit()
    androidTestImplementationEspressoCore()
    androidTestImplementationPlatformComposeBom()
    androidTestImplementationComposeUITestJunit()
    debugImplementationComposeUITooling()
    debugImplementationComposeUITestManifest()

    addCoreModule()
}
