package GameOfLifeSimulation;

import java.util.Random;

public class GameOfLife {

    // Global definierte Konstanten für die beiden Dimensionen
    private static int DIM1;
    private static int DIM2;

    public GameOfLife(int rows, int columns) {
        DIM1 = rows;
        DIM2 = columns;
    }

    public GameOfLife() {
        new GameOfLife(12, 12);
    }

    // Liefert eine zufällig initialisierte Welt
    public boolean[][] initRandomLebendeWelt() {
        Random rand = new Random();
        boolean[][] welt = new boolean[DIM1][DIM2];
        for (int x = 0; x < GameOfLife.DIM1; x++) {
            for (int y = 0; y < GameOfLife.DIM2; y++) {
                if (rand.nextInt(200000) % 2 == 0){
                    welt[x][y] = true;
                }
            }
        }
        return welt;
    }

    public boolean[][] initToteWelt() {
    	return new boolean[DIM1][DIM2];
	}


    // Gibt die aktuelle Welt aus
    public void zeigeWelt(boolean[][] welt) {
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
    boolean[][] wendeRegelnAn(boolean[][] welt) {
        boolean[][] neueWelt = welt;
        for (int x = 0; x < DIM1; x++) {
            for (int y = 0; y < DIM2; y++ ) {
                if (welt[x][y]) {
                    // Regel 3 wird implizit getestet durch regel 1 und 2.
                    if (regelEinsStibtAnEinsamkeit(welt, x, y) || regelZweiStribtAnUeberbevoelkerung(welt, x, y))
                        neueWelt[x][y] = false;
                } else {
                        neueWelt[x][y] = regelVierWirdZumLebenErweckt(welt, x, y);
                }
            }
        }
        return neueWelt;
    }

    // 1. Jede lebendige Zelle, die weniger als zwei lebendige Nachbarn hat, stirbt an Einsamkeit.
    public boolean regelEinsStibtAnEinsamkeit(boolean[][] welt, int x, int y) {
        return (anzahlNachbarn(welt, x, y) < 2);
    }

    // 2. Jede lebendige Zelle mit mehr als drei lebendigen Nachbarn stirbt an Überbevölkerung.
    public boolean regelZweiStribtAnUeberbevoelkerung(boolean[][] welt, int x, int y) {
        return (anzahlNachbarn(welt, x, y) > 3);
    }

    // 4. Jede tote Zelle mit genau drei lebendigen Nachbarn wird wieder zum Leben erweckt.
    public boolean regelVierWirdZumLebenErweckt(boolean[][] welt, int x, int y) {
        return anzahlNachbarn(welt, x, y) == 3;
    }

    // Liefert Anzahl Nachbarn einer Zelle
    private int anzahlNachbarn(boolean[][] welt, int x, int y) {
        int returnValue = 0;
        for (int i = x - (x == 0 ? 0 : 1); i <= x + (x == (DIM1 - 1) ? 0 : 1); ++i)
            for (int j = y - (y == 0 ? 0 : 1); j <= y + (y == (DIM2 - 1) ? 0 : 1); ++j)
                if (welt[i][j])
                    returnValue += 1;
        // einen Nachbarn zuviel mitgezählt?
        if (welt[x][y])
            returnValue -= 1;
        return returnValue;
    }
}
