import java.util.Scanner;

public class JuegoPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del Entrenador 1: ");
        Entrenador ent1 = new Entrenador(sc.nextLine());

        System.out.print("Nombre del Entrenador 2: ");
        Entrenador ent2 = new Entrenador(sc.nextLine());

        ent1.agregarPal(new Pal("Flamix", "Fuego", 50, 30, new ArmamentoEspecial("Llamarada", "ataque", 15, 30)));
        ent1.agregarPal(new Pal("Aguato", "Agua", 40, 40, new ArmamentoEspecial("Escudo", "defensa", 20, 30)));
        ent1.agregarPal(new Pal("Electra", "Eléctrico", 45, 25, new ArmamentoEspecial("Rayo", "daño", 10, 50)));
        ent1.agregarPal(new Pal("Terronix", "Planta", 43, 38, new ArmamentoEspecial("Látigo venenoso", "daño", 13, 40)));

        ent2.agregarPal(new Pal("Plantor", "Planta", 40, 35, new ArmamentoEspecial("Hoja afilada", "ataque", 10, 25)));
        ent2.agregarPal(new Pal("Furagua", "Agua", 42, 30, new ArmamentoEspecial("Burbuja", "defensa", 15, 30)));
        ent2.agregarPal(new Pal("Foguito", "Fuego", 48, 28, new ArmamentoEspecial("Explosión", "daño", 12, 35)));
        ent2.agregarPal(new Pal("Voltrax", "Eléctrico", 44, 27, new ArmamentoEspecial("Descarga", "ataque", 14, 45)));

        for (int i = 0; i < 4; i++) {
            System.out.println("\n--- Ronda " + (i + 1) + " ---");
            Pal p1 = seleccionarPal(sc, ent1);
            Pal p2 = seleccionarPal(sc, ent2);

            Ronda ronda = new Ronda(p1, p2);
            Entrenador ganador = ronda.ejecutarRonda(ent1, ent2);

            if (ganador != null) {
                System.out.println("Ganador de la ronda: " + ganador.getNombre());
            } else {
                System.out.println("Ronda empatada.");
            }

            p1.aplicarEfectoTurno();
            p2.aplicarEfectoTurno();
        }

        System.out.println("\nResultados finales:");
        System.out.println(ent1.getNombre() + " ganó " + ent1.getRondasGanadas() + " rondas.");
        System.out.println(ent2.getNombre() + " ganó " + ent2.getRondasGanadas() + " rondas.");

        Batalla batalla = new Batalla(ent1, ent2);
        Entrenador ganadorFinal = batalla.determinarGanador();
        if (ganadorFinal != null) {
            System.out.println("Ganador final: " + ganadorFinal.getNombre());
        } else {
            System.out.println("La batalla terminó en empate.");
        }

        sc.close();
    }

    public static void mostrarPalsDisponibles(Entrenador entrenador) {
        System.out.println("\nPals disponibles para " + entrenador.getNombre() + ":");
        int i = 0;
        for (Pal pal : entrenador.getPals()) {
            if (!pal.yaUsado()) {
                System.out.println("[" + i + "] " + pal.getNombre() + " (" + pal.getTipo() + ")");
            }
            i++;
        }
    }

    public static Pal seleccionarPal(Scanner sc, Entrenador entrenador) {
        Pal seleccionado = null;
        boolean palValido = false;

        for (int intentos = 0; intentos < 4 && !palValido; intentos++) {
            mostrarPalsDisponibles(entrenador);
            System.out.print("Selecciona el número del Pal: ");
            int idx = sc.nextInt();
            sc.nextLine();
            if (idx >= 0 && idx < entrenador.getPals().size()) {
                Pal pal = entrenador.getPals().get(idx);
                if (!pal.yaUsado()) {
                    pal.setUsado();
                    seleccionado = pal;
                    palValido = true;
                } else {
                    System.out.println("Ese Pal ya fue usado.");
                }
            } else {
                System.out.println("Opción inválida.");
            }
        }
        return seleccionado;
    }
}


