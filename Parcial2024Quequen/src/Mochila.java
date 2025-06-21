import java.util.ArrayList;

public class Mochila {
    private Integer capacidad;
    private ArrayList<Producto> productos;

    public Mochila(Integer capacidad) {
        this.capacidad = capacidad;
        this.productos = new ArrayList<Producto>();
    }

    public Mochila(Integer capacidad, ArrayList<Producto> productos) {
        this.capacidad = capacidad;
        this.productos = new ArrayList<Producto>(productos);
    }

    public ArrayList<Producto> getProductos() {
        return new ArrayList<Producto>(productos);
    }

    public int getPesoRestante() {
        int suma = 0;
        for (Producto pp : productos) {
            suma += pp.getPeso();
        }
        return capacidad - suma;
    }

    public Integer getValor() {
        Integer salida = 0;
        for (Producto pp : productos) {
            salida += pp.getValor();
        }
        return salida;
    }

    public void addProducto(Producto pp) {
        this.productos.add(pp);
    }

    public void removeProducto(Producto pp) {
        productos.remove(pp);
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Mochila [productos=" + productos + "]";
    }

    public void setProductos(ArrayList<Producto> productos2) {
        this.productos = new ArrayList<Producto>(productos2);
    }

    public boolean entra(Producto pp) {
        return this.getPesoRestante() >= pp.getPeso();
    }
    
}
