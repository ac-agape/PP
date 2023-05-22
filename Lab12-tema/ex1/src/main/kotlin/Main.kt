fun main(args: Array<String>) {
    val lista = listOf(1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8);
    println("lista initiala: $lista");

    val filtrata = lista.filter { it >= 5 };
    println("mai mici ca 5: $filtrata");

    val perechi = filtrata.chunked(2).map { pereche -> pereche[0] to pereche[1] };
    println("perechi: $perechi");

    val multiplicate = perechi.map { it.first * it.second };
    println("multiplicate: $multiplicate");

    val suma = multiplicate.sum();
    println("suma: $suma");
}