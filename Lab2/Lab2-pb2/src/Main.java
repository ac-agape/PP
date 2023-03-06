import org.graalvm.polyglot.*;
import java.util.*;

class Main {
    static List<Integer> Generare(int n){
        //construim un context care ne permite sa folosim elemente din PYTHON
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();

        List<Integer> lista = new ArrayList<Integer>(); // creare lista

        for(int i = 0; i<n; ++i) {
            Value result = polyglot.eval("python",
        """
        import random

        random.randint(0, 100)
        """); //generare numere random si stocare in lista

            lista.add(result.asInt());
        }
        polyglot.close();
        return lista; //return
    }

    static void afisare (List<Integer> list){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();

        for(int i = 0; i<list.size(); ++i) {
            polyglot.eval("js", "console.log(" + list.get(i) + ")");
        }
        polyglot.close();
    }

    static List<Integer> RSort(List<Integer> list){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build(); //construim un context care ne permite sa folosim elemente din R

        Value result = polyglot.eval("R", """
        test2 <- function(list){
            sort(list)
            list    
        }""").execute(list);
        ArrayList<Integer> ord_list = new ArrayList<Integer>();
        if (result.hasArrayElements()) {
            for (int i=0;i<result.getArraySize();i++) {
                ord_list.add(result.getArrayElement(i).asInt());
            }
        }
        polyglot.close(); // inchidem contextul Polyglot
        return list;
    }

    public static void main(String[] args) {
        List<Integer> lista;
        lista = Generare(4);
        System.out.println("Sirul initial: \n");
        afisare(lista);

        lista = RSort(lista);
        System.out.println("\nSirul ordonat: \n");
        afisare(lista);
    }

}