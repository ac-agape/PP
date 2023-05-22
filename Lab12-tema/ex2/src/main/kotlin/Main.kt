import java.io.File

fun cezar(text: String, offset: Int): String {
    val result = StringBuilder();

    for (char in text) {
        if (char.isLetter()) {
            var base = 'a';
            base = if (char.isUpperCase())
                'A';
            else
                'a';
            val newIndex = (char.code - base.code + offset) % 26;
            val newChar = (base.code + newIndex).toChar();
            result.append(newChar);
        } else {
            result.append(char);
        }
    }

    return result.toString();
}

fun main() {
    val fileName = "chestiapaoo.txt";
    val offset = 3;
    val inputFile = File(fileName);
    val inputText = inputFile.readText();
    val words = inputText.split(" ");
    val cuvintecezar = words.map { word ->
        if (word.length in 4..7) {
            cezar(word, offset);
        } else {
            word;
        }
    }

    val outputText = cuvintecezar.joinToString(separator = " ");

    println("Rezultat: " + outputText);
}
