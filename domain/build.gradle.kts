plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rguerra.domain"
    compileSdk = 33
    defaultConfig {
        minSdk = 29

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    val rxJavaVersion = "3.0.1"
    val koinVersion = "3.4.2"

    implementation("io.reactivex.rxjava3:rxandroid:$rxJavaVersion")
    api("io.insert-koin:koin-android:$koinVersion")

}