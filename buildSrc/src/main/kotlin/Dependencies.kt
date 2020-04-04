const val kotlinVersion = "1.3.71"

object Libraries {
    private object Versions {
        const val grpcVersion = "1.28.0"
        const val kotlinxCoroutinesVersion = "1.3.5"
        const val krotoPlusVersion = "0.6.1"
        const val protobufVersion = "3.11.4"
        const val javaxAnnotationVersion = "1.3.2"
    }

    const val grpcProtobuf = "io.grpc:grpc-protobuf:${Versions.grpcVersion}"
    const val grpcStub = "io.grpc:grpc-stub:${Versions.grpcVersion}"
    const val grpcNetty = "io.grpc:grpc-netty:${Versions.grpcVersion}"
    const val grpcProtocGen = "io.grpc:protoc-gen-grpc-java:${Versions.grpcVersion}"
    const val kotlinxCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutinesVersion}"
    const val krotoPlusCoroutines = "com.github.marcoferrer.krotoplus:kroto-plus-coroutines:${Versions.krotoPlusVersion}"
    const val krotoPlusGen = "com.github.marcoferrer.krotoplus:protoc-gen-kroto-plus:${Versions.krotoPlusVersion}"
    const val krotoPlusGenGrpcCoro = "com.github.marcoferrer.krotoplus:protoc-gen-grpc-coroutines:${Versions.krotoPlusVersion}"
    const val protobufJava = "com.google.protobuf:protobuf-java:${Versions.protobufVersion}"
    const val protobufCompiler = "com.google.protobuf:protoc:${Versions.protobufVersion}"
    const val javaxAnnotation = "javax.annotation:javax.annotation-api:${Versions.javaxAnnotationVersion}"
}
