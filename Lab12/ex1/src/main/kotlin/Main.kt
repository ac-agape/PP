fun Int.isPrime():Boolean{
    for(i in 2..this/2){
        if(this%i == 0){
            return false;//=>nu este prim
        }
    }
    return true;//=>este prim
}

fun main(args: Array<String>) {
    val v1 = 23;
    val v2 = 4;
    println("v1 prim? " + v1.isPrime());
    println("v2 prim? " + v2.isPrime());
}