class Book(private val data:Content) {

    override fun toString():String {
        return "Author: ${this.data.getAuthor()}\nText: ${this.data.getText()}\n" +
            "Name: ${this.data.getName()}\nPublisher: ${this.data.getPublisher()}"
    }

    fun getName():String {return this.data.getName()}
    fun getAuthor():String {return this.data.getAuthor()}
    //fun getText():String {return this.data.getText()}
    fun getPublisher():String {return this.data.getPublisher()}
    fun getContent():Content {return this.data}

    fun hasAuthor(author:String):Boolean{
        if(this.data.getAuthor() == author){
            return true
        }
        return false
    }

    fun hasTitle(title:String):Boolean{
        if(this.data.getName() == title){
            return true
        }
        return false
    }

    fun isPublishedBy(publisher:String):Boolean{
        if(this.data.getPublisher() == publisher){
            return true
        }
        return false
    }
}