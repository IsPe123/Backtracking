/* 
    Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
    cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
    y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
    camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse
    el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
    booleanos, uno para cada dirección a la que se permite ir desde allí.




    EJERCICIO pendiente, Idea: hacer que laberinto sea una clase.
*/

import java.util.ArrayList;
import java.util.Iterator;

public class EJ2 {
    private Casilla[][] laberinto;
    private ArrayList<Casilla> mejorSolucion;
    private ArrayList<Casilla> visitados;

    public EJ2(int fila, int columna) {
        this.laberinto = new Casilla[fila][columna];
    }

    public void addCasilla(Casilla cc, int posFila,int posColumna) {
        laberinto[posFila][posColumna] = cc;
    }

    public ArrayList<Integer> buscarMejorCamino(Casilla origen, Casilla destino) {
        mejorSolucion.clear();
        visitados.clear();
        visitados.add(origen);
        Iterator it = new Iterator<Casilla>();
        while () {
            
        }
        return mejorSolucion;
    }

    private void buscarCaminos() {
        
    }


}