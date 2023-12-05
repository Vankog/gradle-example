plugins {
    java
    jacoco
}

repositories({
    mavenCentral()
})

tasks.test({
    useJUnitPlatform()
})

jacoco({
    toolVersion = "0.8.11" // https://github.com/jacoco/jacoco/releases
})

java({
    toolchain {
        val version = JavaLanguageVersion.of(21)
        languageVersion.set(version)
        setSourceCompatibility(version)
        setTargetCompatibility(version)
    }
})

tasks.compileJava({
    options.encoding = "UTF-8"
})


