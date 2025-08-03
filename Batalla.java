public class Batalla {
    private Entrenador entrenador1;
    private Entrenador entrenador2;

    public Batalla(Entrenador e1, Entrenador e2) {
        this.entrenador1 = e1;
        this.entrenador2 = e2;
    }

    public Entrenador determinarGanador() {
        if (entrenador1.getRondasGanadas() > entrenador2.getRondasGanadas()) {
            return entrenador1;
        } else if (entrenador2.getRondasGanadas() > entrenador1.getRondasGanadas()) {
            return entrenador2;
        } else {
            return null;
        }
    }
}