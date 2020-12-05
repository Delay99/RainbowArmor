plugins {
    kotlin("jvm") version "1.4.10"
}

group = "kr.delay"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    mavenLocal()
}

val storage = "C:/Users/mello/Desktop/TestServer/plugins"
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("org.spigotmc:spigot-api:1.16.4-R0.1-SNAPSHOT")
}

tasks {
    compileJava.get().options.encoding = "UTF-8"

    jar {
        destinationDirectory.set(file(storage))
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }
}