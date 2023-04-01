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
                implementation(libs.jetbrains.compose.runtime)
                implementation(libs.kotlinx.serialization.core)
                api("app.cash.redwood:redwood-treehouse:0.3.0-SNAPSHOT")
                implementation("app.cash.redwood:redwood-widget:0.3.0-SNAPSHOT")
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