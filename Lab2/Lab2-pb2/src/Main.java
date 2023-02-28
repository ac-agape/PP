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

    public static void main(String[] args) {
        List<Integer> lista;
        lista = Generare(20);
    }
}