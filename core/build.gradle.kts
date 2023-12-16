plugins {
    pluginLibrary()
    pluginAndroidKotlin()
}

android {
    namespace = Config.CORE_LIBRARY
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        minSdk = Config.MIN_SDK
        testOptions.targetSdk = Config.TARGET_SDK

        testInstrumentationRunner = Config.ANDROID_TEST_INSTRUMENTATION
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
}

dependencies {

    implementCoreKtx()
    implementAppCompat()
    implementAndroidMaterial()
    implementComposeBom()
    implementComposeGraphics()
    implementComposeToolingPreview()
    implementComposeMaterial3()
    testImplementationJUnit()
    androidTestImplementationExtJUnit()
    androidTestImplementationEspressoCore()
    debugImplementationComposeUITooling()
}