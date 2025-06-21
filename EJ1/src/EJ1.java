/* 
Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en 
un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que 
permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría 
representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada 
puerta es un arco dirigido hacia otra habitación. 
*/

import java.util.ArrayList;
import java.util.Iterator;

public class EJ1 {
    private ArrayList<Integer> visitados;
    private ArrayList<Integer> solucion;

    public EJ1() {
        this.visitados = new ArrayList<Integer>();
        this.solucion = new ArrayList<Integer>();
    }

    ///////////

    public ArrayList<Integer> buscarCaminoMasLargo(GrafoDirigido<Integer> gr, int origen, int destino) {
        visitados.clear();
        solucion.clear();
        visitados.add(origen);
        Iterator<Integer> it = gr.obtenerAdyacentes(origen);
        while (it.hasNext()) {
            buscarCaminos(gr, it.next(), destino);
        }
        visitados.remove(origen);
        return solucion;
    }

    private void buscarCaminos(GrafoDirigido<Integer> gr, int actual, int destino) {
        if (actual == destino) {
            visitados.add(actual);
            if (visitados.size() > solucion.size()) {
                solucion = new ArrayList<Integer>(visitados);
            }
            visitados.remove(actual);
        } else {
            Iterator<Integer> it = gr.obtenerAdyacentes(actual);
            while (it.hasNext()) {
                Integer num = it.next();
                if (!visitados.contains(num)) {
                    visitados.add(actual);
                    buscarCaminos(gr, num, destino);
                    visitados.remove(actual);
                }
            }
        }
    }


/*  
    public void buscarCaminoMasLargo(GrafoDirigido<Integer> gr, int origen, int salida) {
        visitados.add(origen);

        Iterator<Integer> it = gr.obtenerAdyacentes(origen);
        while (it.hasNext()){
            buscarCaminos(gr, it.next(), salida);
        }
    }

    private void buscarCaminos(GrafoDirigido<Integer> gr, int actual, int destino){
        // Condicion de corte
        if (actual == destino){
            visitados.add(actual);

            if (visitados.size() > solucion.size()){
                solucion = new ArrayList<>(visitados);
            }

        }
        else {
            Iterator<Integer> it = gr.obtenerAdyacentes(actual);
            Integer num = it.next();
            if (!visitados.contains(num)){
                visitados.add(actual);

                while (it.hasNext()){
                    buscarCaminos(gr, it.next(), destino);
                }

                visitados.remove((Integer) actual);
            }
        }
    } 
    */

    ///////////
    
    public ArrayList<Integer> getVisitados() {
        return new ArrayList<>(visitados);
    }

    public void setVisitados(ArrayList<Integer> visitados) {
        this.visitados = visitados;
    }

    public ArrayList<Integer> getSolucion() {
        return new ArrayList<>(solucion);
    }

    public void setSolucion(ArrayList<Integer> solucion) {
        this.solucion = solucion;
    }
}