buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")

    }
    dependencies {
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.jetbrains.compose.gradlePlugin)
        classpath(libs.androidGradlePlugin)
        classpath("app.cash.redwood:redwood-gradle-plugin:0.3.0-SNAPSHOT")
        classpath(libs.kotlin.serializationPlugin)
        classpath(libs.zipline.gradlePlugin)
        classpath(libs.anvil.gradle.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    group = "com.dropbox"
    version = "1.0.0"
}

plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
}