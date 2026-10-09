pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "Ktube"
include(
    ":app",
    ":core:common",
    ":core:data",
    ":core:domain",
    ":core:model",
    ":feature:home",
    ":feature:player",
    ":feature:search",
    ":feature:settings"
)
