/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "androidx.car.app.sample.navigation"
    compileSdk = 35

    defaultConfig {
        applicationId = "androidx.car.app.sample.navigation"
        minSdk = 34
        targetSdk = 35
        versionCode = 114
        versionName = "114"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }

    // android.car exists since Android 10 (API level 29) Revision 5.
    useLibrary("android.car")
    packaging {
        jniLibs {
            useLegacyPackaging = false
        }
    }
}

dependencies {
    // For Android Auto specific functionality
    implementation(libs.androidx.car.app.projected)
    // For testing
    testImplementation(libs.androidx.car.app.testing)

    implementation(project(":navigation:common"))
}
