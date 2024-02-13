plugins {
    id("java")
    id("io.papermc.paperweight.userdev") version "1.5.11"
}
group = "net.realmofuz"
version = "1.0-SNAPSHOT"

java {
    // Configure the java toolchain. This allows gradle to auto-provision JDK 21 on systems that only
    // have JDK 8 installed for example.
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}


repositories {
    mavenCentral()
    maven {
        name = "spigotmc-repo"
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")
    implementation("net.kyori:adventure-text-minimessage:4.15.0")
    implementation("net.kyori:adventure-platform-bukkit:4.3.2")
}

val targetJavaVersion = 21
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    if (JavaVersion.current() < JavaVersion.VERSION_21) {
        toolchain.languageVersion.set(JavaLanguageVersion.of(targetJavaVersion))
    }
}

tasks.withType<JavaCompile>().configureEach {
    if (targetJavaVersion >= 10 || JavaVersion.current().isJava10Compatible) {
        options.release.set(targetJavaVersion)
    }
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(21)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
        val props = mapOf(
            "version" to project.version
        )
        inputs.properties(props)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
    assemble {
        dependsOn(reobfJar)
    }

}