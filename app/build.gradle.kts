plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("plugin.serialization") version "1.6.10"

}

android {
    namespace = "com.example.bluemoney"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bluemoney"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.appcompat)
  //  implementation(libs.androidx.room.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Paypal
    implementation("com.paypal.android:card-payments:1.2.0")
    implementation("com.paypal.sdk:paypal-android-sdk:2.16.0")
    implementation("com.paypal.checkout:android-sdk:1.2.1")
 // implementation ("com.paypal.checkout:android-sdk:2.1.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Converter (Gson for JSON conversion, you can use other converters based on your needs)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Logging interceptor (Optional, for logging HTTP requests and responses)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-alpha02")

    implementation ("androidx.navigation:navigation-compose:2.4.1")

    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}