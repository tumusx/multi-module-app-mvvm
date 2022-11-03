includeBuild("../")
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}


enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("$rootDir/versions.toml"))
        }
    }
}
include(":app")
rootProject.name = "ShoppingListItems"
project(":app").name = "ShoppingListItems"
include(":network")
include(":datasource")
include(":shared")
include(":baseTest")
include(":feature-listImages")
include(":feature-listImages:data")
include(":feature-listImages:domain")
include(":feature-listImages:presenter")
