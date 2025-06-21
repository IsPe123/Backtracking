import java.util.ArrayList;

public class ParcialPeter {
    // Los productos entran una sola vez ¿? supongamos que si
    private Mochila mejorMochila;
    
    public ParcialPeter(Mochila mejorMochila) {
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
    
/*     public static void main(String[] args) {
        Producto p1 = new Producto(100, 500);
        Producto p2 = new Producto(200, 250);
        Producto p3 = new Producto(400, 600);
        Producto p4 = new Producto(1500, 150);
        Producto p5 = new Producto(50, 500);
        Producto p6 = new Producto(900, 5000);
        
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);     
        productos.add(p6); 

        int cap = 1000;

        System.out.println(backtrackingPublico(productos, cap));
    } */


}