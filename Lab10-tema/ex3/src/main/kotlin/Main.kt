import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED

sealed class Message {
    class Number(val n: Int) : Message()
    object End : Message()
}

suspend fun gauss(c: Channel<Message>) {
    while (true) {
        val msg = c.receive()

        when (msg) {
            is Message.Number -> {
                println("corutina ${msg.n}: ${((msg.n + 1) * msg.n) / 2}")
            }
            is Message.End -> break
            else -> Thread.sleep(10)
        }
    }
}

fun coroutines(): Unit = runBlocking {//procesare prin corutine
    val scope = CoroutineScope(newFixedThreadPoolContext(2, "pool"))

    val channel = Channel<Message>(capacity = UNLIMITED)

    val jobs = List(4) { scope.launch { gauss(channel) } }

    for (i in 5..8) {
        channel.send(Message.Number(i))
    }

    for (i in 0..4) {
        channel.send(Message.End)
    }

    jobs.forEach { it.join() }
}

fun threads() { //procesare prin threaduri
    val queue = LinkedBlockingQueue<Message>()

    for (i in 0..3) {
        thread {
            var msg = queue.take()

            while (true) {
                when (msg) {
                    is Message.Number -> println("threadul ${msg.n}: ${((msg.n + 1) * msg.n) / 2}")
                    is Message.End -> break
                }

                msg = queue.take()
            }
        }
    }

    for (i in 5..8) {
        queue.add(Message.Number(i))
    }

    for (i in 0..4) {
        queue.add(Message.End)
    }
}

fun main() {
    threads()
    coroutines()
}

//1.95 teme
//8.55 lab