plugins {
    java
    jacoco
}

repositories({
    mavenCentral()
})

private val optimalForkCount = optimalForkCount()
tasks.withType(Test::class).configureEach({
    useJUnitPlatform()
    setMaxParallelForks(optimalForkCount)
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


private fun optimalForkCount(): Int {
    return (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
}
