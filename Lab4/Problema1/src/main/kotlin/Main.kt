fun main(args: Array<String>) {
    val carte1 = Content("nelkos miroslavas", "astea nu s luate de pe shein ce credeati", "prototip pensule", "mario simen")
    println("Author: ${carte1.getAuthor()}")

    val carticica = Book(carte1)
    println("Cartea are autorul Ion Creanga? " + carticica.hasAuthor("Ion Creanga") +
        "\nCartea are titlul <prototip pensule>? " + carticica.hasTitle("prototip pensule") +
        "\nCartea este publicata de mine? " + carticica.isPublishedBy("Maria"))

    val carte2 = Book(Content("Eminovici", "Sara pe deal", "Poezii", "Libertatea"))
    val carte3 = Book(Content("Ion Creanga", "Pacala", "Amintiri din copilarie", "BibliotecaSaracului"))

    val carti : MutableSet<Book> = mutableSetOf<Book> (carticica, carte2, carte3)
    val library = Library(carti)

    library.addBook(Book(Content("Eminovici", "Luceafarul", "Sunt singur", "mario simen")))
    val same_authors : Library = Library(library.findAllByAuthor("Eminovici"))
}