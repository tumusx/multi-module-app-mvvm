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
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":feature-listImages:domain")))
    implementation(project(mapOf("path" to ":shared")))
    implementation(libs.androidx.core.ktx)
    implementation(libs.coroutines.lifeScope.ktx)
    implementation(libs.coroutines.lifeScope.runTime)
    implementation(libs.coroutine.ktx)
    implementation(libs.koinAndroid)
    implementation(libs.coroutine.android)
    implementation(libs.viewmodel.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.activity.ktx)
    implementation(libs.junit.android.core)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.glide.lib)
    implementation(project(mapOf("path" to ":network")))
    implementation(project(mapOf("path" to ":feature-listImages:data")))
}