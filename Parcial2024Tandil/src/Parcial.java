/* 
    Dado un conjunto C de letras (que tiene más de 4 elementos), se desean generar todas las palabras válidas que
    contengan exactamente 4 letras sin repetir y no empiecen con una letra vocal. Se supone que contamos con una
    clase Diccionario que nos permite verificar si una secuencia de letras es una palabra válida
    <Diccionario.esPalabraValida(string)>.
    Por ejemplo, con C={E, R, N, O, M, A, T} se debería generar una solución compuesta por {MANO, MONA, REMO,
    MORA, RAMO, ROEN, TOMA, ROTA, etc… }
    
    a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué
    información se lleva en los estados.
    
    b) Escriba un algoritmo en pseudo-java que resuelva el problema mediante la técnica de Backtracking.
    
    c) ¿Se podría plantear alguna poda que minimice la cantidad de estados generados por el Backtracking?
*/

import java.util.ArrayList;

public class Parcial {
    private ArrayList<ArrayList<Character>> palabrasSalida;
    private int limite;

    public Parcial(int limite) {
        this.limite = limite;
        this.palabrasSalida = new ArrayList<ArrayList<Character>>();
    }

    public ArrayList<ArrayList<Character>> buscarPalabras(ArrayList<Character> letras) {
        ArrayList<Boolean> letrasUsadas = new ArrayList<Boolean>();
        ArrayList<Character> solucionParcial = new ArrayList<Character>();
        for (int i = 0; i < letras.size(); i++) {
            letrasUsadas.add(false);
        }
        backtracking(letras, letrasUsadas, solucionParcial);
        return palabrasSalida;
    }

    private void backtracking(ArrayList<Character> letras, ArrayList<Boolean> letrasUsadas, ArrayList<Character> solucionParcial) {
        if (solucionParcial.size() == this.limite) {
            /*if ( && Diccionario.esPalabraValida(string) ) {*/
                palabrasSalida.add(new ArrayList<>(solucionParcial));    
            /* } */    
        } else {
            for (int i = 0; i < letras.size(); i++) {
                if (!letrasUsadas.get(i)) {
                    letrasUsadas.set(i, true);
                    solucionParcial.add(letras.get(i));

                    backtracking(letras, letrasUsadas, solucionParcial);

                    solucionParcial.remove(solucionParcial.size() -1);
                    letrasUsadas.set(i, false);
                }
            }
        }
    }

}