pluginManagement {
    repositories {
        jcenter()
        google()
        gradlePluginPortal()
    }

    plugins {
        id(BuildPlugins.dektPlugin) version Versions.dekt
        id(BuildPlugins.androidApplication) version Versions.buildToolsVersion
        id(BuildPlugins.kotlinAndroid) version Versions.kotlin
        id(BuildPlugins.kotlinAndroidExtensions) version Versions.kotlin
        id(BuildPlugins.dynamicFeature) version Versions.buildToolsVersion
        id(BuildPlugins.androidLibrary) version Versions.buildToolsVersion
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                BuildPlugins.androidApplication,
                BuildPlugins.androidLibrary,
                BuildPlugins.dynamicFeature -> useModule(BuildPlugins.androidGradlePlugin)
            }
        }
    }
}

include(
    BuildModules.Libraries.App,
    BuildModules.Libraries.Core,
    BuildModules.Libraries.Network,

    BuildModules.Features.Home,
    BuildModules.Features.Humors,
    BuildModules.Features.MyPage
)

rootProject.name = "Youtugo"