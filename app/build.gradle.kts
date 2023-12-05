plugins {
    alias(libs.plugins.spring.boot)
    id("common-conventions")

    `test-report-aggregation`
    `jacoco-report-aggregation`

    id("com.dorongold.task-tree").version("2.1.1")
}

group = "app.dmo.gradletest.app"
version = "unspecified"

tasks.withType(Test::class).configureEach({
    finalizedBy(
        tasks.testAggregateTestReport,
        tasks.testCodeCoverageReport
    )
})

dependencies({
    implementation(project(":service"))
    implementation(libs.spring.boot.web)

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter", "junit-jupiter")
    testImplementation(libs.spring.boot.test)
    testImplementation("org.assertj", "assertj-core", "3.24.2")
    testImplementation("org.hamcrest", "hamcrest", "2.2")

    testRuntimeOnly("org.junit.platform", "junit-platform-launcher")
})
