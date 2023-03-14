class Birth(val year: Int, val Month: Int, val Day: Int){
    override fun toString() : String{
        return "($Day.$Month.$year)"
    }
}
class Contact(val Name: String, val Phone: String, val BirthDate: Birth){
    fun Print() {
        println("Name: $Name, Mobile: $Phone, Date: $BirthDate")
    }
}

fun search_phone (list : MutableList<Contact>, nr: String) : Int{
    var ok : Int
    ok = -1
    for (persoana in list){
        ok++;
        if(persoana.Phone == nr){
            Print("S-a gasit persoana cu nr. de telefon cautat.")
            persoana.Print()
            return ok;
        }
    }
    ok=-1;
    return ok
}

fun main(args : Array<String>){
    val agenda = mutableListOf<Contact>()
    agenda.add(Contact("Mihai", "0744321987", Birth(1900, 11, 25)))
    agenda += Contact("George", "0761332100", Birth(2002, 3, 14))
    agenda += Contact("Liviu" , "0231450211", Birth(1999, 7, 30))
    agenda += Contact("Popescu", "0211342787", Birth(1955, 5, 12))
    for (persoana in agenda){
        persoana.Print()
    }
    println("Agenda dupa eliminare contact [George]:")
    agenda.removeAt(1)
    for (persoana in agenda){
        persoana.Print()
    }
    agenda.remove(Contact("Liviu" , "0231450211", Birth(1999, 7, 30)))
    println("Agenda dupa eliminare contact [Liviu]:")
    agenda.removeAt(1)
    for (persoana in agenda){
        persoana.Print()
    }

    val index : Int
    val persoana : Contact
    fun Print(message: "\nSe cauta persoana cu nr. de telefon 0744321987: ")
    index = search_phone(agenda, "0744321987");
    if(index==-1){
        Print("Nu s-a gasit...")
    }
    else {
        persoana = agenda.get(index)
    }
    persoana.Print()
}

//cam gata ex1, mai am de printat frumos :)