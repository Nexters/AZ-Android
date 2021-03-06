plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.safeArgs)
}

android {
    compileSdkVersion(AndroidSDK.compile)
    buildToolsVersion("29.0.2")

    defaultConfig {
        applicationId = "com.az.youtugo"
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
        versionCode = Versions.code
        versionName = Versions.name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    dataBinding {
        isEnabled = true
    }

    viewBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    dynamicFeatures = mutableSetOf(
        BuildModules.Features.Main,
        BuildModules.Features.MyPage,
        BuildModules.Features.Alarm,
        BuildModules.Features.Login,
        BuildModules.Features.Signup,
        BuildModules.Features.Alarm,
        BuildModules.Features.Create,
        BuildModules.Features.Details
    )
}

dependencies {
    api(project(BuildModules.Libraries.Core))
    api(project(BuildModules.Libraries.Model))
    implementation(project(BuildModules.Libraries.Repository))
    implementation(project(BuildModules.Libraries.Network))
    api(project(BuildModules.Libraries.InfiniteRecyclerview))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    api(Libraries.constraintLayout)

    // Koin
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinExt)
    implementation(Libraries.koinScope)
    implementation(Libraries.koinViewModel)

    implementation(Libraries.lifecycleCommon)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.lifecycleLiveData)
    implementation(Libraries.lifecycleRuntime)

    api(Libraries.navigationFragment)
    api(Libraries.navigationUI)
    api(Libraries.navigationDynamicFeature)
    api(Libraries.fragments)
    api(Libraries.materialComponents)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}
