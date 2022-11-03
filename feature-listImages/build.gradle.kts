plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 27
        targetSdk = 32
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.koinAndroid)
    implementation(libs.koinCore)
    implementation(libs.retrofit)
    implementation(project(mapOf("path" to ":network")))
    implementation(project(mapOf("path" to ":feature-listImages:data")))
    implementation(project(mapOf("path" to ":feature-listImages:domain")))
    implementation(project(mapOf("path" to ":feature-listImages:presenter")))
}