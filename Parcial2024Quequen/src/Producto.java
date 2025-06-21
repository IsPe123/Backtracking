public class Producto {
    private Integer peso;
    private Integer valor;

    public Producto(Integer peso, Integer valor) {
        this.peso = peso;
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Producto [peso=" + peso + ", valor=" + valor + "]";
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

}
