plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("com.squareup.anvil")
}

android {

    defaultConfig {
        minSdk = 27
    }

    compileSdk = 33
    compileSdkVersion = "android-33"

    namespace = "com.dropbox.pokedex.android.common.scoping"
}

dependencies {
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
}