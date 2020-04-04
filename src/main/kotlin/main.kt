import io.grpc.ServerBuilder
import io.grpc.inprocess.InProcessServerBuilder

fun main() {
    val server = ServerBuilder.forPort(3009)
        .addService(GreeterService())
        .directExecutor()
        .build()
    server.start()
    print("Server started, listening on ${server.port}")
    server.awaitTermination()
}
