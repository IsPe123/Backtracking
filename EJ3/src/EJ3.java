/* 
    Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
    combinaciones de esos números tal que la suma sea igual a M.
*/

import java.util.ArrayList;

public class EJ3 {
/*     
    private ArrayList<ArrayList<Integer>> soluciones;
    private ArrayList<Integer> solucionParcial;
    private ArrayList<Integer> numeros;
    private Integer m;

    public EJ3(Integer m, ArrayList<Integer> numeros) {
        this.soluciones = new ArrayList<ArrayList<Integer>>();
        this.numeros = numeros;
        this.m = m;
    }

    public ArrayList<ArrayList<Integer>> buscar() {
        soluciones.clear();
        solucionParcial.clear();

        for(Integer i = 0; i < numeros.size(); i++) {
            solucionParcial.clear();
            solucionParcial.add(numeros.get(i));
            buscarPrivado(i);
        }
        
        return soluciones;
    }

    private void buscarPrivado(Integer contador) {
        if (sumaSolucionParcial() ) {
            
        } else {

        }
    }
*/









    public ArrayList<ArrayList<Integer>> encontrarSubconjuntos(int[] numeros, int objetivo) {
        ArrayList<ArrayList<Integer>> resultados = new ArrayList<>();
        ArrayList<Integer> caminoActual = new ArrayList<>();
        backtrack(numeros, objetivo, 0, 0, caminoActual, resultados);
        return resultados;
    }

    private void backtrack(int[] numeros, int objetivo, int indice, int sumaActual,
                                  ArrayList<Integer> caminoActual, ArrayList<ArrayList<Integer>> resultados) {
        // Caso base: si la suma es exactamente igual al objetivo
        if (sumaActual == objetivo) {
            resultados.add(new ArrayList<>(caminoActual)); // Guardamos una copia del camino
            return;
        }

        // Si nos pasamos del objetivo o ya no quedan elementos, no seguimos
        if (sumaActual > objetivo || indice >= numeros.length) {
            return;
        }

        // Elegir el número en la posición actual
        caminoActual.add(numeros[indice]);
        backtrack(numeros, objetivo, indice + 1, sumaActual + numeros[indice], caminoActual, resultados);

        // Retroceder (backtrack): quitar el número y probar sin él
        caminoActual.remove(caminoActual.size() - 1);
        backtrack(numeros, objetivo, indice + 1, sumaActual, caminoActual, resultados);
    }



// Ejemplo de uso
/*  
    public static void main(String[] args) {
        int[] numeros = {2, 4, 6, 10};
        int objetivo = 16;

        ArrayList<ArrayList<Integer>> subconjuntos = encontrarSubconjuntos(numeros, objetivo);

        System.out.println("Subconjuntos cuya suma es " + objetivo + ":");
        for (ArrayList<Integer> subconjunto : subconjuntos) {
            System.out.println(subconjunto);
        }
    } */

}