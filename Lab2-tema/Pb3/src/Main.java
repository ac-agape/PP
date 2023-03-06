import org.graalvm.polyglot.*;
import java.util.*;

public class Main {
    private static double prob(int n, int x) {
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value result = polyglot.eval("R", """
                                    prob <- function(x, n) {
                                    return(dbinom(x, n, 0.5))
                                    }
                                    """).execute(x, n);

        return result.asDouble();
    }
    public static void main(String[] args) {
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value result = polyglot.eval("python",
                """
x = [0, 0]
x[0] = input('Introduceti n: ')
x[1] = input('Introduceti x: ')
x""");

        int n = Integer.parseInt(result.getArrayElement(0).asString());
        int x = Integer.parseInt(result.getArrayElement(1).asString()); // convertesc in int

        if(x < 1 || x > n){
            System.out.printf("datele introduse nu sunt valide");
            return;
        }

        System.out.printf("prob: %f", prob(n, x));
    }
}