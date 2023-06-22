import com.github.gradle.node.npm.task.NpmTask
import org.gradle.kotlin.dsl.processResources
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
    kotlin("plugin.jpa") version "1.8.21"
    id("com.github.node-gradle.node") version "5.0.0"
}

group = "net.jsrois"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    implementation("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")


}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}


fun buildClient(prefix: String, path: String, destinationPath: String) {
    val installFrontendDependencies = tasks.register<NpmTask>("${prefix}InstallDependencies") {
        workingDir.set(file(path))
        args.set(listOf("install"))
    }

    val compileWebClient = tasks.register<NpmTask>("${prefix}CompileClient") {
        dependsOn(installFrontendDependencies)
        workingDir.set(file(path))
        args.set(listOf("run", "build"))
    }

    val copyFiles = tasks.register<Copy>("${prefix}CopyFiles") {
        dependsOn(compileWebClient)
        from("${path}/dist")
        into(destinationPath)
    }

    tasks.processResources {
        dependsOn(copyFiles)
    }
}

buildClient("app","./web-client","./src/main/resources/static/app")
buildClient("backoffice", "./web-client-backoffice", "./src/main/resources/static/backoffice")

