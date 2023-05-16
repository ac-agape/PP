fun main(args: Array<String>) {
    val map =
        mapOf("abc" to 1, "def" to 2, "ghi" to 3);

    val invertedMap = map.entries.associateBy({it.value}) {it.key};

    println(map);
    println(invertedMap);
}