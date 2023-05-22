import java.util.Scanner
import kotlin.math.pow
import kotlin.math.sqrt

fun distance(x1:  Int, y1: Int, x2: Int, y2: Int) = sqrt(((x1 - x2).toDouble()*(x1 - x2).toDouble() + (y1 - y2).toDouble()*(y1 - y2).toDouble()));

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`);

    val n = reader.nextInt();

    var sum = 0.0;
    var x1 = reader.nextInt();
    var y1 = reader.nextInt();

    for (i in 0..n-2){
        var x2 = reader.nextInt();
        var y2 = reader.nextInt();

        sum += distance(x1, y1, x2, y2);

        x1=x2; y1 = y2;
        println("x: $x1, y: $y1");
    }

    println("perimetru = $sum");
}

/*
4
0 0
0 1
1 0
1 1
 */