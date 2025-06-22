import java.util.ArrayList;

public class Parcial {
    // Los productos entran una sola vez ¿? supongamos que si
    private Mochila mejorMochila;
    
    public Parcial(Mochila mejorMochila) {
        this.mejorMochila = mejorMochila;
    }

    public Mochila backtrackingPublico(ArrayList<Producto> productos) {
        ArrayList<Boolean> usados = new ArrayList<Boolean>();
        for (int i = 0; i < productos.size(); i++) {
            usados.add(false);
        }
        Mochila mochilaAux = new Mochila(mejorMochila.getCapacidad());
        backtrackingPrivado(mochilaAux, productos, usados);
        return this.mejorMochila;
    }

    public void backtrackingPrivado(Mochila mochilaAux, ArrayList<Producto> productos, ArrayList<Boolean> usados) {
        if (mochilaAux.getPesoRestante() <= buscarMinPeso(productos)) {
            System.out.println("Se lleno la mochila auxiliar");
            if (mochilaAux.getValor() > mejorMochila.getValor()) {
                System.out.println("Se cambio la mejor mochila");
                mejorMochila = new Mochila(mochilaAux.getCapacidad(), mochilaAux.getProductos());
            }
        } else {
            for (int i = 0; i < productos.size(); i++) {
                Producto pp = productos.get(i);
                if (!usados.get(i)) {
                    if (mochilaAux.entra(pp)) {
                        mochilaAux.addProducto(pp);
                        usados.set(i, true);

                        backtrackingPrivado(mochilaAux, productos, usados);

                        usados.set(i, false);
                        mochilaAux.removeProducto(pp);     
                    }    
                }            
            }
        }
    }

    private int buscarMinPeso(ArrayList<Producto> productos) {
        int menorPeso = 99999;
        for (Producto pp : productos) {
            if (pp.getPeso() < menorPeso) {
                menorPeso = pp.getPeso();
            }
        }
        return menorPeso;
    }


}