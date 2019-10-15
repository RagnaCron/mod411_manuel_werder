package GameOfLifeSimulation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameOfLife {

    // Global definierte Konstanten für die beiden Dimensionen
    private final static int DIM1 = 12;
    private final static int DIM2 = 12;

    // Liefert eine zufällig initialisierte Welt
    private boolean[][] initWelt() {
        Random rand = new Random();
        boolean[][] welt = new boolean[GameOfLife.DIM1][GameOfLife.DIM2];
        for (int x = 0; x < GameOfLife.DIM1; x++) {
            for (int y = 0; y < GameOfLife.DIM2; y++) {
                if (rand.nextInt(200000) % 2 == 0){
                    welt[x][y] = true;
                }
            }
        }
        return welt;
    }


    // Gibt die aktuelle Welt aus
    private void zeigeWelt(boolean[][] welt) {
        for (int x = 0; x < GameOfLife.DIM1 ; x++) {
            for (int y = 0; y < GameOfLife.DIM2; y++) {
                System.out.print((welt[x][y]? 1 : 0) + "  ");
            }
            System.out.println();
        }
    }

    // Wendet die 4 Regeln an und gibt die Folgegeneration wieder zurück
    // 1. Jede lebendige Zelle, die weniger als zwei lebendige Nachbarn hat, stirbt an Einsamkeit.
    // 2. Jede lebendige Zelle mit mehr als drei lebendigen Nachbarn stirbt an Überbevölkerung.
    // 3. Jede lebendige Zelle mit zwei oder drei Nachbarn fühlt sich wohl und lebt weiter.
    // 4. Jede tote Zelle mit genau drei lebendigen Nachbarn wird wieder zum Leben erweckt.
    private boolean[][] wendeRegelnAn(boolean[][] welt) {
        for (int x = 0; x < GameOfLife.DIM1; x++) {
            for (int y = 0; y < GameOfLife.DIM2; y++ ) {
                int nachbarn = anzahlNachbarn(welt, x, y);
                if (welt[x][y]) {
                    if (nachbarn  < 2 || nachbarn > 3) {
                        welt[x][y] = false;
                    }
                } else {
                    if (nachbarn == 3) {
                        welt[x][y] = true;
                    }
                }

            }
        }
        return welt;
    }

    // Liefert Anzahl Nachbarn einer Zelle
    private int anzahlNachbarn(boolean[][] welt, int x, int y) {
        int returnValue = 0;
        for (int i = x - (x == 0 ? 0 : 1); i <= x + (x == 11 ? 0 : 1); ++i)
            for (int j = y -(y == 0 ? 0 : 1); j <= y + (y == 11 ? 0 : 1); ++j)
                if (welt[i][j])
                    returnValue += 1;
        // einen Nachbarn zuviel mitgezählt?
        if (welt[x][y])
            returnValue -= 1;
        return returnValue;
    }

    public static void main(String[] args) {

        GameOfLife game = new GameOfLife();
        SimulationView view = new SimulationView(DIM1, DIM2);
        // Welt initialisieren
        boolean[][] welt = game.initWelt();
        int counter = 1;
        while (view.isActiv(welt)) {
            view.showStatus(counter, welt);
            welt = game.wendeRegelnAn(welt);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if( counter == 100) System.exit(0);
            counter++;
        }



//        System.out.println("Startkonstellation");
//        game.zeigeWelt(welt);
//
//        for (int i = 1; i <= 100; i++) {
//            welt = game.wendeRegelnAn(welt);
//            System.out.println("Generation " + i);
//            game.zeigeWelt(welt);
//        }
    }
}