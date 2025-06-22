import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Recu rr = new Recu();

        ArrayList<Integer> conjunto = new ArrayList<>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);

        System.out.println(rr.generarPermutaciones(conjunto));

    }
}