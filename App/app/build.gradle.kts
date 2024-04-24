import org.apache.http.util.Args
import org.jetbrains.kotlin.load.kotlin.JvmType

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

// 定义Project的扩展函数，用于执行shell命令并获取输出
fun execAndGetStdout(args: List<String>): String {
    val process = ProcessBuilder()
        .command(args)
        .redirectErrorStream(true)
        .start()

    process.waitFor()
    return process.inputStream.bufferedReader().use { it.readText() }
}

//  git rev-list HEAD --count
val cmd = mutableListOf("git", "rev-list", "HEAD", "--count")
// 输出提交次数
println("Git commit count: ${execAndGetStdout(cmd)}")

val commitCount = execAndGetStdout(cmd).trim().toInt()


android {
    namespace = "com.jz.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jz.app"
        minSdk = 19
        targetSdk = 34
        versionCode = commitCount
        versionName = "1.0"
        //解决65535
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(libs.androidx.constraintlayout)
    implementation(project(":lib-common"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
}


