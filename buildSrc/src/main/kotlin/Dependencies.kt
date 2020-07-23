object Versions {
    const val name = "1.0"
    const val code = 1
    const val kotlin = "1.3.72"
    const val coroutines = "1.3.3"
    const val buildToolsVersion = "3.6.0"

    const val jetPack = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val ktx = "1.1.0"
    const val koin = "2.1.6"
    const val v7 = "28.0.0"
    const val material = "1.1.0-rc02"

    const val junit4 = "4.12"
    const val testRunner = "1.0.2"
    const val espresso = "3.0.2"

    const val dekt = "1.7.4"
    const val navVersion = "2.3.0-rc01"
    const val fragments = "1.2.5"

    const val retrofit = "2.7.2"
    const val interceptor = "3.4.1"
    const val okHttp = "3.2.0"
    const val gson = "2.3.0"
    const val moshi = "1.9.3"
}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinAndroidExtensions = "org.jetbrains.kotlin.android.extensions"
    const val dynamicFeature = "com.android.dynamic-feature"
    const val androidLibrary = "com.android.library"
    const val kotlinKapt = "kotlin-kapt"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
    const val safeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"
    const val dektPlugin = "io.gitlab.arturbosch.detekt"
}

object Libraries {
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val coroutinesLibrary =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroidLibrary =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val appCompatX = "androidx.appcompat:appcompat:${Versions.jetPack}"
    const val appCompat = "com.android.support:appcompat-v7:${Versions.v7}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"

    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinScope = "org.koin:koin-android-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val koinExt = "org.koin:koin-android-ext:${Versions.koin}"
    const val koinCore = "org.koin:koin-core:${Versions.koin}"

    // networking
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gson}"
    const val moshiConverter = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"

    // navigation
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    const val navigationDynamicFeature =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navVersion}"
    const val fragments = "androidx.fragment:fragment-ktx:${Versions.fragments}"

    // material design
    const val materialComponents = "com.google.android.material:material:${Versions.material}"
}

object TestLibraries {
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}

object AndroidSDK {
    const val min = 21
    const val compile = 29
    const val target = compile
}

object BuildModules {
    object Features {
        const val Home = ":features:home"
        const val Humors = ":features:humors"
        const val MyPage = ":features:mypage"
    }

    object Libraries {
        const val Core = ":core"
        const val App = ":app"
        const val Model = ":model"
        const val Repository = ":data:repository"
        const val Network = ":data:network"
    }
}