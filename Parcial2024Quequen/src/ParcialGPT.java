/* 
    Dado un conjunto de productos N donde cada producto tiene un peso Pi y un valor económico Vi, y una mochila con
    capacidad máxima de K kilos. Se desea encontrar el subconjunto de productos a ubicar en la mochila que
    maximice el valor económico total, sin superar los K kilos disponibles. Se sabe que los productos no pueden ser
    fraccionados, es decir, si se elige poner un producto X en la mochila deberá hacerse en su totalidad.

    a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y que
    información se lleva en los estados.
    b) Escriba un pseudo-java del algoritmo que resuelva el problema mediante Backtracking.

*/

import java.util.ArrayList;

public class ParcialGPT {

    int mejorValor = 0;

    public void resolverMochila(ArrayList<Producto> productos, int capacidadMaxima) {
        backtrack(productos, 0, 0, 0, capacidadMaxima);
        System.out.println("Valor máximo posible: " + mejorValor);
    }

    private void backtrack(ArrayList<Producto> productos, int indice, int pesoActual, int valorActual, int capacidadMaxima) {
        // Caso base: fin de la lista
        if (indice == productos.size()) {
            if (valorActual > mejorValor) {
                mejorValor = valorActual;
            }
            return;
        }

        Producto p = productos.get(indice);

        // Opción 1: Incluir el producto si no excede la capacidad
        if (pesoActual + p.peso <= capacidadMaxima) {
            backtrack(productos, indice + 1, pesoActual + p.peso, valorActual + p.valor, capacidadMaxima);
        }

        // Opción 2: No incluir el producto
        backtrack(productos, indice + 1, pesoActual, valorActual, capacidadMaxima);

    }
}


/* class Producto {
    int peso;
    int valor;
} */