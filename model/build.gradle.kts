plugins {
    `java-library`
    id("common-conventions")
}

group = "app.dmo.gradletest.model"
version = "unspecified"


dependencies({
    implementation(libs.spring.boot.web)

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter", "junit-jupiter")
    testImplementation("org.assertj", "assertj-core", "3.24.2")

    testRuntimeOnly("org.junit.platform", "junit-platform-launcher")

})
