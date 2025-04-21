import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64() // Para iOS em macOS (simulador)
    iosArm64() // Para iOS em dispositivos reais
    iosSimulatorArm64() // Para iOS em simuladores em Macs com Apple Silicon
    sourceSets {
        val ktorVersion = "2.3.0"

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation("io.ktor:ktor-client-darwin:$ktorVersion")

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(projects.shared)
            // Ktor Client Core
            implementation("io.ktor:ktor-client-core:$ktorVersion")

            // Ktor Client ContentNegotiation
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")

            // Ktor Client JSON serialization
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

            // kotlinx.serialization
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:$ktorVersion")

        }
        dependencies{
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0") // ou versão compatível
        }
    }
}

android {
    namespace = "com.nutrium.demo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.nutrium.demo"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.ktor.client.darwin)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.json)
    implementation(libs.ktor.client.serialization)
    debugImplementation(compose.uiTooling)
}

