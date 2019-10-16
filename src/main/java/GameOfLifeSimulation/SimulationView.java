package GameOfLifeSimulation;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * URSPRUNG:
 * https://github.com/dsenften/ict-404/tree/master/src/main/java/simulation
 *
 * Eine grafische Ansicht des Simulationsfeldes.
 * Die Ansicht zeigt für jede Position ein gefärbtes Rechteck,
 * das den jeweiligen Inhalt repräsentiert, und hat eine
 * vorgebene Hintergrundfarbe.
 */
@SuppressWarnings("WeakerAccess")
public class SimulationView extends JFrame {

    // Die Farbe für True
    private static final Color LIFE_COLOR = Color.BLACK;

    // Die Farbe für für False
    private static final Color DEAD_COLOR = Color.WHITE;

    private JLabel stepLabel, population;
    private FieldView fieldView;

    /**
     * Erzeuge eine Ansicht mit der gegebenen Breite und Höhe.
     *
     * @param height Die Höhe der Simulation.
     * @param width  Die Breite der Simulation.
     */
    public SimulationView(int height, int width) {

        setTitle("Simulation von Leben und Tot");

        setLocation(100, 50);

        fieldView = new FieldView(height, width);

        Container container = getContentPane();
        container.add(fieldView, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    /**
     * @return die definierte Farbe für die gegebene Tierklasse.
     */
    private Color getColor(boolean[][] world, int x, int y) {
        return world[x][y] ? LIFE_COLOR : DEAD_COLOR;
    }

    /**
     * Zeige den aktuellen Zustand des Feldes.
     *
     * @param world   die welt.
     */
    public void showStatus(boolean[][] world) {
        if (!isVisible())
            setVisible(true);

        fieldView.prepareView();

        for (int row = 0; row < 12; row++) {
            for (int column = 0; column < 12; column++) {
                fieldView.drawField(column, row, getColor(world, row, column));
            }
        }
        fieldView.repaint();
    }

    /**
     * Entscheide, ob die Simulation weiterlaufen soll.
     *
     * @return true wenn noch mehr als eine feld true ist.
     */
    public boolean isActiv(boolean[][] world) {
        int counter = 0;
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 12; y++) {
                if (world[x][y]) counter++;
            }
        }
        return counter > 1;
    }

    /**
     * Liefere eine grafische Ansicht eines rechteckigen Feldes.
     * Dies ist eine geschachtelte Klasse (eine Klasse, die
     * innerhalb einer anderen Klasse definiert ist), die eine
     * eigene grafische Komponente für die Benutzungsschnittstelle
     * definiert. Diese Komponente zeigt das Field an.
     * Dies ist fortgeschrittene GUI-Technik - Sie können sie
     * für Ihr Projekt ignorieren, wenn Sie wollen.
     */
    private class FieldView extends JPanel {
        private static final long serialVersionUID = 20060330L;
        private final int FACTOR = 6;

        private int fieldWidth, fieldHeight;
        private int xFactor, yFactor;

        Dimension size;
        private Graphics g;
        private Image image;

        /**
         * Erzeuge eine neue Komponente zur FieldView.
         */
        public FieldView(int height, int width) {
            fieldHeight = height;
            fieldWidth = width;
            size = new Dimension(0, 0);
        }

        /**
         * Der GUI-Verwaltung mitteilen, wie gross wir sein wollen.
         * Der Name der Methode ist durch die GUI-Verwaltung festgelegt.
         */
        public Dimension getPreferredSize() {
            return new Dimension(fieldWidth * FACTOR,
                    fieldHeight * FACTOR);
        }

        /**
         * Bereite eine neue Zeichenrunde vor. Da die Komponente
         * in der Grsse geändert werden kann, muss der Massstab neu
         * berechnet werden.
         */
        public void prepareView() {
            if (!size.equals(getSize())) {
                size = getSize();
                image = fieldView.createImage(size.width, size.height);
                g = image.getGraphics();

                xFactor = size.width / fieldWidth;
                if (xFactor < 1) {
                    xFactor = FACTOR;
                }
                yFactor = size.height / fieldHeight;
                if (yFactor < 1) {
                    yFactor = FACTOR;
                }
            }
        }

        /**
         * Zeichne an der gegebenen Position ein Rechteck mit
         * der gegebenen Farbe.
         */
        public void drawField(int x, int y, Color farbe) {
            g.setColor(farbe);
            g.fillRect(x * xFactor, y * yFactor, xFactor - 1, yFactor - 1);
        }

        /**
         * Die Komponente für die FieldView muss erneut angezeigt
         * werden. Kopiere das interne Image in die Anzeige.
         * Der Name der Methode ist durch die GUI-Verwaltung festgelegt.
         */
        public void paintComponent(Graphics g) {
            if (image != null) {
                Dimension actualSize = getSize();
                if (size.equals(actualSize)) {
                    g.drawImage(image, 0, 0, null);
                } else {
                    // Grösse des aktuellen Images anpassen.
                    g.drawImage(image, 0, 0, actualSize.width,
                            actualSize.height, null);
                }
            }
        }
    }
}
