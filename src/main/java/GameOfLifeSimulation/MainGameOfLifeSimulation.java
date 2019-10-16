package GameOfLifeSimulation;

public class MainGameOfLifeSimulation {

	public static void main(String[] args) {

		GameOfLife game = new GameOfLife();
		SimulationView view = new SimulationView(12, 12);

		// Welt initialisieren
		boolean[][] welt = game.initRandomLebendeWelt();
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
	}

}
