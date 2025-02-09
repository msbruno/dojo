plugins {
    java
    application
}

group = ""
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.example.App"
    }
}
