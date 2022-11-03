buildscript {

    repositories {
        google()
        mavenCentral()
    }



    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

plugins {
    id("com.jraska.module.graph.assertion") version "2.3.0" apply false
}

tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}