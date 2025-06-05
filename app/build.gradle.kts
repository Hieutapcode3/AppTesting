plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.appiumtestproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.appiumtestproject"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.guava)
    testImplementation(libs.junit)
    testImplementation(libs.appium)
    testImplementation(libs.selenium)
    testImplementation(libs.testng)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Appium, Selenium, TestNG cho androidTest
    androidTestImplementation(libs.appium)
    androidTestImplementation(libs.selenium)
    androidTestImplementation(libs.testng)
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "com.google.guava" && requested.name == "guava") {
            useVersion("31.1-jre")
        }
    }
}

tasks.withType<Test>().configureEach {
    useTestNG()
}
