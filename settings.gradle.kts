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
    BuildModules.Libraries.Model,
    BuildModules.Libraries.Repository,
    BuildModules.Libraries.Network,

    BuildModules.Features.Main,
    BuildModules.Features.Humors,
    BuildModules.Features.MyPage,
    BuildModules.Features.Alarm,
    BuildModules.Features.Create,
    BuildModules.Features.Details
)

rootProject.name = "Youtugo"