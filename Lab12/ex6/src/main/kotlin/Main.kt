fun main(args: Array<String>) {
    println("String pls: ");
    val txt = readLine();

    val no_duplicates = txt?.splitToSequence("")?.distinct()?.joinToString("", "", "");

    println("After removing duplicates: ");
    println(no_duplicates);
}