//import libraria principala polyglot din graalvm
import org.graalvm.polyglot.*;
import java.util.*;

//clasa principala - aplicatie JAVA
class Main {
    //metoda privata pentru conversie low-case -> up-case folosind functia toupper() din R
    private static String RToUpper(String token){
        //construim un context care ne permite sa folosim elemente din R
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        //folosim o variabila generica care va captura rezultatul excutiei funcitiei R, toupper(String)
        //pentru aexecuta instructiunea I din limbajul X, folosim functia graalvm polyglot.eval("X", "I");
        Value result = polyglot.eval("R", "toupper(\""+token+"\");");
        //utilizam metoda asString() din variabila incarcata cu output-ul executiei pentru a mapa valoarea generica la un String
        String resultString = result.asString();
        // inchidem contextul Polyglot
        polyglot.close();

        return resultString;
    }

    //metoda privata pentru evaluarea unei sume de control simple a literelor unui text ASCII, folosind PYTHON
    private static int SumCRC(String token){
        //construim un context care ne permite sa folosim elemente din PYTHON
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        //folosim o variabila generica care va captura rezultatul excutiei functiei PYTHON, sum()
        //avem voie sa inlocuim anumite elemente din scriptul pe care il construim spre evaluare, aici token provine din JAVA, dar va fi interpretat de PYTHON
        Value result = polyglot.eval("python", "sum(ord(ch) for ch in '" + token + "')");
        //utilizam metoda asInt() din variabila incarcata cu output-ul executiei, pentru a mapa valoarea generica la un Int
        int resultInt = result.asInt();
        // inchidem contextul Polyglot
        polyglot.close();

        return resultInt;
    }


    //functie de calcul in mod diferit al sumei de control, folosind polinomul P(x) = x^3 - x^2 - x;
    private static int polinomCRC(int sumaCRC){
        int rez = sumaCRC * sumaCRC * sumaCRC - sumaCRC * sumaCRC - sumaCRC;
        return rez;
    }

    private static String stringCRC(String token){
        int len = token.length()-1;
        if(len <=2){
            return "0";
        }
        String rez = token.substring(1, token.length()-1);
        return rez;
    }

    //functia MAIN
    public static void main(String[] args) {
        //construim un context pentru evaluare elemente JS
        Context polyglot = Context.create();
        //construim un array de string-uri, folosind cuvinte din pagina web:  https://chrisseaton.com/truffleruby/tenthings/
        Value array = polyglot.eval("js", "[\"good\",\"morning\",\"sunshine\",\"i\",\"like\", \"your\", \"lkie\"];");
        //pentru fiecare cuvant, convertim la upcase folosind R si calculam suma de control folosind PYTHON
        HashMap<Integer, ArrayList<String>> words = new HashMap<>(); // tablou de dispersie pt sumele de control si cuvintele respective


        for (int i = 0; i < array.getArraySize();i++){
            String element = array.getArrayElement(i).asString();
            String upper = RToUpper(element);
            int crc = SumCRC(upper);
            int policrc = polinomCRC(crc);
            int substringcrc = SumCRC(stringCRC(upper));
            System.out.println(upper + " -> " + crc + " -> " + policrc + " -> " + substringcrc);

            ArrayList<String> rep_list;
            if (words.containsKey(crc)) { // caz deja exista acea suma de control
                rep_list = words.get(crc); // salvez lista existenta
            }
            else {
                rep_list = new ArrayList<>(); // creez o lista noua
            }
            rep_list.add(upper); // actualizarea listei
            words.put(crc, rep_list); // adaug lista in tabloul de dispersie
        }

        //afisare
        for(Integer i : words.keySet()) {
            ArrayList<String> rep_words = words.get(i);
            System.out.printf("%d -> [", i);
            for(String word : rep_words){
                System.out.printf("%s ", word);
            }
            System.out.println("]");
        }

        // inchidem contextul Polyglot
        polyglot.close();
    }
}

