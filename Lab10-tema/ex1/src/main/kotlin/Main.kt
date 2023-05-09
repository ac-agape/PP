import java.util.concurrent.*
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

sealed class Message {
    class Number(val n: Int) : Message()
    object End : Message()
}

fun th(list: List<Int>, alpha: Int) { //procesare prin threaduri
    val numbers = LinkedBlockingQueue<Message>()
    val sorted = LinkedBlockingQueue<List<Int>>()

    thread() {
        for (n in list) {
            numbers.put(Message.Number(n * alpha))
        }

        numbers.put(Message.End)
    }


    thread() {
        val unsortedList = mutableListOf<Int>()

        var msg = numbers.take()

        while (true) {
            when (msg) {
                is Message.Number -> unsortedList.add(msg.n)
                is Message.End -> break
            }

            msg = numbers.take()
        }

        sorted.add(unsortedList.sorted().toList())
    }

    thread() {
        println(sorted.take())
    }
}

fun cr(list: List<Int>, alpha: Int) = runBlocking {//procesare prin corutine
    val messageQueue = Channel<Message>(UNLIMITED)
    val sortedQueue = Channel<List<Int>>(1)

    launch {
        for (elem in list) {
            messageQueue.send(Message.Number(elem * alpha))
        }

        messageQueue.send(Message.End)
    }

    launch {
        val mul = mutableListOf<Int>()

        for (msg in messageQueue) {
            when (msg) {
                is Message.Number -> mul.add(msg.n)
                is Message.End -> break
            }
        }

        sortedQueue.send(mul.sorted().toList())
    }

    launch {
        println(sortedQueue.receive())
    }
}

fun main() {
    val list = List(100) { Random.nextInt() }
    val a = Random.nextInt()

    th(list, a)
    cr(list, a)
}