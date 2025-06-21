/* 
    Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en
    dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma.
*/

import java.util.ArrayList;

public class EJ4 {

    public EJ4() {}

    public boolean puedePartirse(ArrayList<Integer> granConjunto) {
        Integer suma = 0;
        for (Integer ii : granConjunto) {
            suma += ii;
        }
        if (suma % 2 == 0) {
            return backtracking(granConjunto, 0, 0, suma / 2, new ArrayList<Integer>());
        } else {
            return false;
        }
    }

    private boolean backtracking(ArrayList<Integer> granConjunto ,Integer indice, Integer sumaActual, Integer objetivo, ArrayList<Integer> subconjunto){
        if (sumaActual == objetivo)
            return true;
        
        if (sumaActual > objetivo || indice >= granConjunto.size())
            return false;

        // Incluir el elemento actual
        subconjunto.add(granConjunto.get(indice));
        if (backtracking(granConjunto, indice + 1, sumaActual + granConjunto.get(indice), objetivo, subconjunto))
            return true;

        subconjunto.remove(subconjunto.size() - 1);
        return backtracking(granConjunto, indice + 1, sumaActual, objetivo, subconjunto);
    }

}