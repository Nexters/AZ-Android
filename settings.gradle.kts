pluginManagement {
    repositories {
        jcenter()
        google()
        gradlePluginPortal()
    }

    plugins {
        id("io.gitlab.arturbosch.detekt") version "1.7.4"
        id("com.android.application") version "4.0.0"
        id("org.jetbrains.kotlin.android") version "1.3.72"
        id("org.jetbrains.kotlin.android.extensions") version "1.3.72"
        id("com.android.dynamic-feature") version "4.0.0"
        id("com.android.library") version "4.0.0"
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.library",
                "com.android.dynamic-feature" -> useModule("com.android.tools.build:gradle:4.0.0")
            }
        }
    }
}

include(
        ":app",
        ":core"
)

rootProject.name = "Youtugo"