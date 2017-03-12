import org.gradle.api.JavaVersion.VERSION_1_7

plugins {
    application                                            // includes java plugin, easier to execute during testing
    id("com.github.johnrengelman.shadow") version "1.2.4"  // creates an executable fat JAR (includes dependencies)
    id("edu.sc.seis.macAppBundle") version "2.1.6"         // creates an OS X bundle
}

allprojects {
    group = "com.mariolopezjr"
    version = "0.7.0-SNAPSHOT"
}

java {
    sourceCompatibility = VERSION_1_7
    targetCompatibility = VERSION_1_7
}

repositories {
    mavenCentral()
}

var mainClassNameProp: String by extra
mainClassNameProp = "com.mariolopezjr.tetris.TetrisApp"

application {
    mainClassName = mainClassNameProp
}

macAppBundle {
    mainClassName = mainClassNameProp
    icon = "build-resources/osx/icons/icon_256.icns"
}

dependencies {
    compile("com.google.inject:guice:3.0")
    compile("commons-configuration:commons-configuration:1.9")
    compile("commons-beanutils:commons-beanutils:1.8.3")
    compile("commons-jxpath:commons-jxpath:1.3")
    compile("ch.qos.logback:logback-core:1.0.13")
    compile("ch.qos.logback:logback-classic:1.0.13")
    compile("org.slf4j:slf4j-api:1.7.5")

    testCompile("junit:junit:3.8.1")
}