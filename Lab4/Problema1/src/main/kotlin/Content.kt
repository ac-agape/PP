class Content {
    private var author: String
    private var text: String
    private var name: String
    private var publisher: String

    constructor(author: String, text: String, name: String, publisher: String) {
        this.author = author
        this.text = text
        this.name = name
        this.publisher = publisher
    }

    fun getAuthor():String {return this.author}
    fun setAuthor(author:String) {this.author = author};
    fun getText():String {return this.text};
    fun setText(text:String) {this.text = text};
    fun getName():String {return this.name};
    fun setName(name:String) {this.name = name};
    fun getPublisher():String {return this.publisher};
    fun setPublisher(publisher:String) {this.publisher = publisher};
}