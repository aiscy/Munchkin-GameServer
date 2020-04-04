import com.google.protobuf.gradle.*

plugins {
    java
    application
    idea
    kotlin("jvm") version kotlinVersion
    id("com.google.protobuf") version "0.8.12"
}

group = "org.example.munchkin"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(Libraries.kotlinxCoroutines)

    implementation(Libraries.grpcNetty)
    implementation(Libraries.grpcProtobuf)
    implementation(Libraries.grpcStub)

    implementation(Libraries.krotoPlusCoroutines)
    implementation(Libraries.protobufJava)

    implementation(Libraries.javaxAnnotation)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
        kotlinOptions.freeCompilerArgs + "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

kotlin.sourceSets["main"].kotlin.srcDirs("src/main/kotlin")
kotlin.sourceSets["test"].kotlin.srcDirs("src/test/kotlin")
sourceSets["main"].resources.srcDirs("src/main/resources")
sourceSets["test"].resources.srcDirs("src/test/resources")

protobuf {
    protoc {
        artifact = Libraries.protobufCompiler
    }

    plugins {
        id("coroutines") {
            artifact = Libraries.krotoPlusGenGrpcCoro
        }
        id("grpc") {
            artifact = Libraries.grpcProtocGen
        }
    }

    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                id("coroutines")
                id("grpc")
            }
        }
    }
}
