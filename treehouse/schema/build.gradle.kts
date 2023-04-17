plugins {
    kotlin("jvm")
    id("app.cash.redwood.schema")
}

dependencies {
    api("app.cash.redwood:redwood-layout-schema:0.3.0-SNAPSHOT")
    api("app.cash.redwood:redwood-treehouse-lazylayout-schema:0.3.0-SNAPSHOT")
    implementation(project(":treehouse:state"))
    implementation(project(":treehouse:componentbox"))
}

redwoodSchema {
    type.set("com.dropbox.pokedex.treehouse.schema.Pokedex")
}