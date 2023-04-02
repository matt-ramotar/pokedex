pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        kotlin("multiplatform").version(extra["kotlin.version"] as String)
        kotlin("android").version(extra["kotlin.version"] as String)
        id("com.android.application").version(extra["agp.version"] as String)
        id("com.android.library").version(extra["agp.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
    }
}

rootProject.name = "pokedex"


include(
    ":android:app",
    ":android:common:pig",
    ":android:common:scoping",
    ":android:common:treehouse",
    ":common:api",
    ":common:client",
    ":common:entity",
    ":treehouse:foundation",
    ":treehouse:launcher",
    ":treehouse:presenter",
    ":treehouse:schema",
    ":treehouse:schema:compose",
    ":treehouse:schema:compose:protocol",
    ":treehouse:schema:widget",
    ":treehouse:schema:widget:protocol",
    ":treehouse:state",
    ":treehouse:zipline"
)