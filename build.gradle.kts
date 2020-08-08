// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.dektPlugin)
    id(BuildPlugins.dynamicFeature) apply false
    id(BuildPlugins.androidLibrary) apply false
    id(BuildPlugins.androidApplication) apply false
    id(BuildPlugins.kotlinAndroid) apply false
    id(BuildPlugins.kotlinAndroidExtensions) apply false
    id(BuildPlugins.safeArgs) apply false
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
    }
}
buildscript {
    val kotlin_version by extra("1.3.72")
    dependencies {
        "classpath"("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

subprojects {
    apply(plugin = BuildPlugins.dektPlugin)
    detekt {
        config = files("${project.rootDir}/detekt.yml")
        parallel = true
    }
}

tasks.register("clean").configure {
    delete("build")
}