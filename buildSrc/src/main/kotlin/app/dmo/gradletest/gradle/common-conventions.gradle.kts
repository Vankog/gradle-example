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
    val version = JavaLanguageVersion.of(21)
    /*
     * when you configure a JVM toolchain, it will automatically set the sourceCompatibility and targetCompatibility for you.
     * It will set the values for both to the version of the toolchain.
     * However, you can override this behavior by explicitly changing these values.
     * Note: Configuring a JVM toolchain is the preferred way over setting up the sourceCompatibility and targetCompatibility.
     */
    //setSourceCompatibility(version)
    //setTargetCompatibility(version)
    toolchain {
        languageVersion.set(version)
        // setSourceCompatibility(version)
        // setTargetCompatibility(version) // By default, the targetCompatibility is set to the same value as the sourceCompaitiblity (if it is set).
    }
})

tasks.compileJava({
    options.encoding = "UTF-8"
})


private fun optimalForkCount(): Int {
    return (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
}
