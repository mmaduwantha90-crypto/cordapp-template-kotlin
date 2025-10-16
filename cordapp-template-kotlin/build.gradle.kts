plugins {
    kotlin("jvm") version "1.5.31"
    id("net.corda.plugins.cordformation") version "5.0.0"
}

group = "com.template"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.corda:corda-core:5.0")
    implementation("net.corda:corda-finance:5.0")
    implementation("net.corda:corda-serialization:5.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
}

tasks.withType<Jar> {
    manifest {
        attributes["Implementation-Title"] = "Corda Patient Flow"
        attributes["Implementation-Version"] = version
    }
    from(sourceSets.main.get().output)
}

tasks.register<Copy>("copyCordapp") {
    from(tasks.jar)
    into("$buildDir/libs")
}

tasks.build {
    dependsOn(tasks.copyCordapp)
}