/* 

    Se tiene un conjunto de N elementos y se quieren obtener todas las formas distintas de colocar esos elementos en
    una secuencia .
    Por ejemplo, para el conjunto {1, 2, 3} se deben obtener las siguientes secuencias 
    {1, 2, 3), {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1).
    a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué
    información se lleva en los estados.
    b) Escriba un algoritmo java que resuelva el problema mediante Backtracking.

*/

import java.util.ArrayList;

public class Recu {

    public ArrayList<ArrayList<Integer>> generarPermutaciones(ArrayList<Integer> conjunto) {
        ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Boolean> usados = new ArrayList<>();

        for (int i = 0; i < conjunto.size(); i++) {
            usados.add(false);
        }

        backtracking(conjunto, actual, usados, resultado);
        return resultado;
    }

    private void backtracking(ArrayList<Integer> conjunto, ArrayList<Integer> actual, ArrayList<Boolean> usados, ArrayList<ArrayList<Integer>> resultado) {

        if (actual.size() == conjunto.size()) {
            resultado.add(new ArrayList<>(actual));
        } else {
            for (int i = 0; i < conjunto.size(); i++) {
                if (!usados.get(i)) {
                    usados.set(i, true);
                    actual.add(conjunto.get(i));

                    backtracking(conjunto, actual, usados, resultado);

                    actual.remove(actual.size() - 1);
                    usados.set(i, false);
                }
            }
        }
    }

}
