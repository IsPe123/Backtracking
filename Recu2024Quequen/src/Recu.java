/* 
Se tiene un conjunto de N elementos y se quieren obtener todas las formas distintas de colocar esos elementos en una secuencia .
Por ejemplo, para el conjunto {1, 2, 3} se deben obtener las siguientes secuencias {1, 2, 3), {1, 3, 2}, {2, 1, 3}, {2, 3, 1},
{3, 1, 2}, {3, 2, 1).
    a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué
        información se lleva en los estados.
    b) Escriba un algoritmo java que resuelva el problema mediante Backtracking.
*/

import java.util.ArrayList;

public class Recu {
    /* private ArrayList<Integer> N; */
    private ArrayList<Integer> solucionParcial;
    private ArrayList<ArrayList<Integer>> solucionFinal;
    private ArrayList<Boolean> usados;


    public Recu() {
        this.solucionFinal = new ArrayList<ArrayList<Integer>>();
        this.solucionParcial = new ArrayList<Integer>();
        this.usados = new ArrayList<Boolean>();
    }

    public ArrayList<ArrayList<Integer>> generarResultados(ArrayList<Integer> N) {
        solucionFinal.clear();
        solucionParcial.clear();
/*      Integer aux = N.size();
        Integer res = 0;
        while (res < aux) {
            generarResultadosBacktracking(N, res);    
            res++;
        } */
        generarResultadosBacktracking(N); 
        return solucionFinal;
    }

    public void generarResultadosBacktracking(ArrayList<Integer> N) {
        if (solucionParcial.size() == N.size()) {
            this.solucionFinal.add(new ArrayList<>(solucionParcial));
        } else {
            for (int i = 0; i < N.size(); i++) {
                solucionParcial.add(N.get(actual));
                usados.set(i,true);
                generarResultadosBacktracking(N);
                solucionParcial.remove(solucionParcial.size() - 1);
                usados.set(i, false);
            }
        }

        /*         
        for (int i = 0; i < N.size(); i++) {
            if (!usados[i]) {
                // Usamos el elemento i
                usados[i] = true;
                actual.add(conjunto.get(i));

                // Llamada recursiva
                backtrack(conjunto, actual, usados);

                // Backtrack: deshacemos la elección
                actual.remove(actual.size() - 1);
                usados[i] = false;
            }
        }
         */
    }
}










/* 
import java.util.ArrayList;

public class Permutaciones {

    public static void generarPermutaciones(ArrayList<Integer> conjunto) {
        ArrayList<Integer> actual = new ArrayList<>();
        boolean[] usados = new boolean[conjunto.size()];
        backtrack(conjunto, actual, usados);
    }

    private static void backtrack(ArrayList<Integer> conjunto, ArrayList<Integer> actual, boolean[] usados) {
        if (actual.size() == conjunto.size()) {
            System.out.println(actual);
            return;
        }

        for (int i = 0; i < conjunto.size(); i++) {
            if (!usados[i]) {
                // Usamos el elemento i
                usados[i] = true;
                actual.add(conjunto.get(i));

                // Llamada recursiva
                backtrack(conjunto, actual, usados);

                // Backtrack: deshacemos la elección
                actual.remove(actual.size() - 1);
                usados[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> conjunto = new ArrayList<>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);

        System.out.println("Permutaciones del conjunto:");
        generarPermutaciones(conjunto);
    }
}

 */