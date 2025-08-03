public class Pal {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private ArmamentoEspecial armamento;
    private boolean usado;
    private boolean efectoActivo;
    private int efectoRestante;

    public Pal(String nombre, String tipo, int ataque, int defensa, ArmamentoEspecial armamento) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.armamento = armamento;
        this.usado = false;
        this.efectoActivo = false;
        this.efectoRestante = 0;
    }

    public boolean usarArmamento() {
        if (armamento.activar()) {
            efectoActivo = true;
            efectoRestante = 2;
            return true;
        }
        return false;
    }

    public int getAtaqueTotal(Pal enemigo) {
        int total = ataque;
        if (efectoActivo && armamento.getEfecto().equals("ataque")) {
            total += armamento.getValor();
        } else if (efectoActivo && armamento.getEfecto().equals("daño")) {
            total += armamento.getValor();
        }
        int bono = calcularBonificacionTipo(this.tipo, enemigo.tipo);
        total += bono;
        return total;
    }

    private int calcularBonificacionTipo(String tipoAtacante, String tipoDefensor) {
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Planta")) return 20;
        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Agua")) return 20;
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Fuego")) return 20;
        if (tipoAtacante.equals("Eléctrico") && tipoDefensor.equals("Agua")) return 20;

        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Agua")) return -10;
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Planta")) return -10;
        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Fuego")) return -10;

        return 0;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean yaUsado() {
        return usado;
    }

    public void setUsado() {
        usado = true;
    }

    public void aplicarEfectoTurno() {
        if (efectoActivo) {
            efectoRestante--;
            if (efectoRestante == 0) {
                efectoActivo = false;
            }
        }
    }
}