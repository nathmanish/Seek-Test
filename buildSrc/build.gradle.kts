plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

tasks {

    compileJava {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}