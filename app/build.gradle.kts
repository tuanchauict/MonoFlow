plugins {
    kotlin("js")
}

repositories {
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation(project(":htmlcanvas"))
    implementation(project(":livedata"))
}

kotlin {
    js(IR) {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}
