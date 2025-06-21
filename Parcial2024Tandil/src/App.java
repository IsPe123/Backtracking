import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Parcial pp = new Parcial(3);

        ArrayList<Character> letras = new ArrayList<Character>();
        letras.add('a');
        letras.add('e');
        letras.add('i');
        letras.add('o');
        letras.add('u');

        System.out.println(pp.buscarPalabras(letras));
    }
}
