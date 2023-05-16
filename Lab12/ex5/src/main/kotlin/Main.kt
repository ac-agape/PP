import java.util.Scanner;

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`);
    print("n = ");
    var n = reader.nextInt();

    val myArrayList = ArrayList<Int>()
    for (i in 0..n-1){
        myArrayList.add(reader.nextInt());
    }
    println(myArrayList);

    for (i in 0..n-1){
        for (j in 0..n-2) {
            myArrayList.add(myArrayList[i]);
        }
    }

    println(myArrayList);
}