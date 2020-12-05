plugins {
    kotlin("jvm") version "1.4.10"
}

group = "kr.delay"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    mavenLocal()
}

val storage = "C:/Users/mello/Desktop/TestServer/plugins"
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("com.destroystokyo.paper", "paper-api", "1.16.4-R0.1-SNAPSHOT")
}

tasks {
    compileJava.get().options.encoding = "UTF-8"

    jar {
        destinationDirectory.set(file(storage))
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }
}