import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Mochila mm = new Mochila(1000);
        ParcialPeter par1 = new ParcialPeter(mm);

        Producto p1 = new Producto(96, 100);
        Producto p2 = new Producto(100, 250);
        Producto p3 = new Producto(500, 600);
        Producto p4 = new Producto(500, 550);
        Producto p5 = new Producto(500, 1000);
        Producto p6 = new Producto(300, 350);

        
        ArrayList<Producto> productos = new ArrayList<>();
        

        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
                
        Mochila moc = par1.backtrackingPublico(productos);

        System.out.println(moc);
        System.out.println(moc.getPesoRestante());
        System.out.println(moc.getValor());
    }
}
