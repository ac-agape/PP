class Library(private val Books:MutableSet<Book>) {
    fun getBooks():Set<Book> {return this.Books}
    fun addBook(book:Book) {this.Books.add(book)}

    fun findAllByAuthor(author:String):MutableSet<Book>{
        val aux : MutableSet<Book> = mutableSetOf<Book>()
        for(i in this.Books){
            if(i.getAuthor() == author){
                aux.add(i)
            }
        }
        return aux
    }
    fun findAllByName(name:String):MutableSet<Book>{
        val aux : MutableSet<Book> = mutableSetOf<Book>()
        for(i in this.Books){
            if(i.getName() == name){
                aux.add(i)
            }
        }
        return aux
    }
    fun findAllByPublisher(publisher:String):MutableSet<Book>{
        val aux : MutableSet<Book> = mutableSetOf<Book>()
        for(i in this.Books){
            if(i.getPublisher() == publisher){
                aux.add(i)
            }
        }
        return aux
    }

}