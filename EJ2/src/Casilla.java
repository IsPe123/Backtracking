import java.util.Iterator;

public class Casilla {
    private Integer valor;
    private boolean oeste;
    private boolean sur;
    private boolean este;
    private boolean norte;

    public Casilla(Integer v, boolean o, boolean s, boolean e, boolean n) {
        this.valor = v;
        this.oeste = o;
        this.sur = s;
        this.este = e;
        this.norte = n;
    }

    public boolean isOeste() {
        return oeste;
    }

    public void setOeste(boolean oeste) {
        this.oeste = oeste;
    }

    public boolean isSur() {
        return sur;
    }

    public void setSur(boolean sur) {
        this.sur = sur;
    }

    public boolean isEste() {
        return este;
    }

    public void setEste(boolean este) {
        this.este = este;
    }

    public boolean isNorte() {
        return norte;
    }

    public void setNorte(boolean norte) {
        this.norte = norte;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
