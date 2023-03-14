fun main(args: Array<String>) {
    val content = Content("nelkos miroslavas", "astea nu s luate de pe shein ce credeati", "prototip pensule", "mario simen pensionarilor")
    println("Author: ${content.getAuthor()}")

    val carticica = Book(content)
    println("Cartea are autorul Ion Creanga? " + carticica.hasAuthor("Ion Creanga") +
        "\nCartea are titlul <prototip pensule>? " + carticica.hasTitle("prototip pensule") +
        "\nCartea este publicata de mine? " + carticica.isPublishedBy("Maria"))
}