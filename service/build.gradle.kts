plugins {
    `java-library`
    id("common-conventions")
}

group = "app.dmo.gradletest.service"
version = "unspecified"

dependencies({
    api(project(":model"))
    implementation(libs.spring.boot.starter)

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter", "junit-jupiter")
    testImplementation("org.assertj", "assertj-core", "3.24.2")

    testRuntimeOnly("org.junit.platform", "junit-platform-launcher")
})
