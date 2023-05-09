package com.pp.laborator
import java.io.File
class Log private constructor() {
    companion object {
        val instance = Log()
        val fname = "Semafor.txt"
    }
    fun Write(line : String) {
        File(fname).appendText(line)
    }
    fun Reset(){
        File(fname).delete()
    }
}
class Semafor private constructor() {
    fun Enter() : Boolean {
        //synchronized(File(//TBD - file path))
            //read() sau write()
    }
    fun Exit() {
        //synchronized(File..)
        //...
    }
}