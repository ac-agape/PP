package com.pp.laborator
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.sync.Mutex
import kotlin.system.*

sealed class ContorMsg
object IncContor : ContorMsg()
class GetContor(val response: CompletableDeferred<Int>) : ContorMsg()

fun CoroutineScope.counterActor() = actor<ContorMsg> {
    var contor = 0
    for (msg in channel) {
        when (msg) {
            is IncContor -> contor++
            is GetContor -> msg.response.complete(contor)
        }
    }
}

suspend fun CoroutineScope.massiveRun(action: suspend () -> Unit){
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n) {
            launch { repeat(k) { action() } }
        }
        jobs.forEach { it.join() }
    }
    println("S-au efectuat ${n * k} operatii in $time ms")
}
val mtContext = newFixedThreadPoolContext(2, "mtPool")
var counter = 0

fun main() = runBlocking<Unit> {
    /* subpunctul 1
    val m = Mutex()
    CoroutineScope(mtContext).massiveRun {
        m.lock()
        counter++ //variabila comuna unde vor aparea erori
        m.unlock()
    }
    println("Numarator = $counter")
    */

    val contor = counterActor()
    GlobalScope.massiveRun()
    {
        contor.send(IncContor)
        println(contor.onSend)
    }
    val raspuns = CompletableDeferred<Int>()
    contor.send(GetContor(raspuns))
    println("Contor = ${raspuns.await()}")
    contor.close()
}