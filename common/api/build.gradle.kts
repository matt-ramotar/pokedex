plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

kotlin {
    android()
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    js(IR) {
        browser()
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.jetbrains.compose.runtime)
                api(project(":common:entity"))
                api(project(":common:client"))
            }
        }
    }
}

android {
    compileSdk = 33
    compileSdkVersion = "android-33"
    defaultConfig {
        minSdk = 27
    }
    namespace = "com.dropbox.pokedex.common.api"
}