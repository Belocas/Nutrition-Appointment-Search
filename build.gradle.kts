
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    kotlin("plugin.serialization") version "1.9.10"
}
allprojects {
    repositories {
        google()          // Repositório do Google (necessário para dependências Android)
        mavenCentral()    // Repositório Maven Central (onde o Ktor será baixado)
        maven { url = uri("https://kotlin.bintray.com/ktor") }
    }
}
subprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://kotlin.bintray.com/ktor") }
    }
}