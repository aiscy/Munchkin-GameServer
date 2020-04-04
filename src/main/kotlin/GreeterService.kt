import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ThreadContextElement
import kotlinx.coroutines.asContextElement
import online.senpai.munchkin.GreeterCoroutineGrpc
import online.senpai.munchkin.HelloReply
import online.senpai.munchkin.HelloRequest
import kotlin.coroutines.CoroutineContext

class GreeterService : GreeterCoroutineGrpc.GreeterImplBase() {
    private val myThreadLocal: ThreadContextElement<String> = ThreadLocal.withInitial { "value" }.asContextElement()
    override val initialContext: CoroutineContext
        get() = Dispatchers.Default + myThreadLocal

    override suspend fun sayHello(request: HelloRequest): HelloReply {
        return HelloReply.newBuilder()
            .setMessage("Herro, ${request.name.reversed()}!")
            .build()
    }
}
