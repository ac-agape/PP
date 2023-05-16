import kotlin.properties.*

fun Int.isPrime():Boolean{
    for (i in 2..this/2){
        if(this%i == 0){
            return false;
        }
    }
    return true;
}

fun main(args: Array<String>) {
    var prime: Int by
    Delegates.vetoable(7) { property, oldValue, newValue ->
        val prime = newValue.isPrime()
        println("" + newValue + " prim? " + prime);
        prime
    }
    prime = 2;
    prime = 3;
    prime = 4;
}