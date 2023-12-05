plugins {
    `kotlin-dsl`
}

repositories({
    gradlePluginPortal()
})

java({
    toolchain({
        var version = JavaLanguageVersion.of(21)
        languageVersion.set(version)
        setSourceCompatibility(version)
        setTargetCompatibility(version)
    })
})


tasks.compileJava({
    options.encoding = "UTF-8"
})
