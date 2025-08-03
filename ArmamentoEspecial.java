public class ArmamentoEspecial {
    private String nombre;
    private String efecto; // "ataque", "defensa", "daño"
    private int valor;
    private int probabilidad;

    public ArmamentoEspecial(String nombre, String efecto, int valor, int probabilidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }

    public boolean activar() {
        int aleatorio = (int) (Math.random() * 100);
        return aleatorio < probabilidad;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }
}
