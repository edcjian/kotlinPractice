import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.31"
    kotlin("plugin.spring") version "1.4.31"
    kotlin("kapt") version "1.4.20"

}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8


repositories {
    mavenCentral()
}

dependencies {

    implementation("com.baomidou:mybatis-plus:3.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    kapt("com.querydsl:querydsl-apt:4.4.0:jpa")
    kapt("io.arrow-kt:arrow-core:0.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.1.0")
    implementation("io.arrow-kt:arrow-core:0.13.1")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("io.arrow-kt:arrow-core:0.13.1")
    implementation(kotlin("reflect"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
//        kotlinOptions.freeCompilerArgs += "-Xopt-in=org.mylibrary.OptInAnnotation"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
//        useIR = true
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.4"
}