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
                implementation(libs.jetbrains.compose.runtime)
            }
        }
    }
}

android {
    compileSdk = 31
    compileSdkVersion = "android-31"
    defaultConfig {
        minSdk = 27
    }
}