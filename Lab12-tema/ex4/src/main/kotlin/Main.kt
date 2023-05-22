import java.util.*

class TestFunctor<K, V>(val map: MutableMap<K, V>) {
    fun map(function: (K, V) -> Pair<K, V>) = TestFunctor(map.map {
        function(it.key, it.value)
    }.toMap(mutableMapOf()))
}

fun String.toPascalCase(): String = this.split(" ").joinToString(separator = "") {
    it.replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.getDefault())
        else
            it.toString()
    }
}

fun main() {
    val map = mutableMapOf(
        1 to "pushi",
        2 to "este",
        3 to "o",
        4 to "pisica",
        5 to "cam",
        6 to "crazy"
    )

    var functor = TestFunctor(map)
    functor = functor.map { k, v -> Pair(k, "Test $v") }
    functor = functor.map { k, v -> Pair(k, v.toPascalCase())}

    println(functor.map)
}