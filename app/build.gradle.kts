plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.jraska.module.graph.assertion")
}

android {
    namespace = "com.github.tumusx.shoppinglistitems"
    compileSdk = 32

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.github.tumusx.shoppinglistitems"
        minSdk = 27
        targetSdk = 32
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = ("1.8")
    }

}


dependencies {
    implementation(libs.bundles.android.core)
    implementation(project(mapOf("path" to ":feature-listImages:presenter")))
    implementation(project(mapOf("path" to ":feature-listImages")))
    implementation(libs.koinCore)
    implementation(libs.koinAndroid)
}