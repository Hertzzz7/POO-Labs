import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private List<Pal> pals;
    private int rondasGanadas;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pals = new ArrayList<>();
        this.rondasGanadas = 0;
    }

    public void agregarPal(Pal pal) {
        if (pals.size() < 4) {
            pals.add(pal);
        }
    }

    public List<Pal> getPals() {
        return pals;
    }

    public void incrementarRondasGanadas() {
        rondasGanadas++;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public String getNombre() {
        return nombre;
    }
}
