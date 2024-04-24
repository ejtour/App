plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.jz.lib_common"
    compileSdk = 34

    defaultConfig {
        minSdk = 19

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
//    api 'com.squareup.retrofit2:retrofit:2.5.0'
//    api 'com.squareup.retrofit2:adapter-rxjava2:2.5.0'
//    api 'com.squareup.retrofit2:converter-jackson:2.0.2'
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    api("com.squareup.retrofit2:converter-moshi:2.9.0")////转换器，Gson 已经不怎么维护了，ReadMe
    api("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")
         //https://github.com/square/moshi
    implementation ("com.squareup.moshi:moshi:1.12.0")

    //Okhttp
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")
}