public class Ronda {
    private Pal pal1;
    private Pal pal2;
    private Entrenador ganador;

    public Ronda(Pal pal1, Pal pal2) {
        this.pal1 = pal1;
        this.pal2 = pal2;
    }

    public Entrenador ejecutarRonda(Entrenador ent1, Entrenador ent2) {
        pal1.usarArmamento();
        pal2.usarArmamento();

        int poder1 = pal1.getAtaqueTotal(pal2);
        int poder2 = pal2.getAtaqueTotal(pal1);

        if (poder1 > poder2) {
            ent1.incrementarRondasGanadas();
            ganador = ent1;
        } else if (poder2 > poder1) {
            ent2.incrementarRondasGanadas();
            ganador = ent2;
        } else {
            ganador = null;
        }

        return ganador;
    }
}