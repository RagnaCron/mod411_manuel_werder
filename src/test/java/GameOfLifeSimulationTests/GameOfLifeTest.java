package GameOfLifeSimulationTests;

import GameOfLifeSimulation.GameOfLife;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameOfLifeTest {

	private GameOfLife game;
	private boolean[][] welt;
	private boolean[][] erwarteteWelt;

	@BeforeEach
	void setup() {
		game = new GameOfLife(3, 3);
		welt = game.initDeadWorld();
	}

	@Test
	void initToteWelt() {
		boolean[][] erwarteteWelt = new boolean[3][3];
		assertArrayEquals(welt, erwarteteWelt);
	}

	@Test
	void regelEinsStibtAnEinsamkeit() {
		welt[1][1] = true;
		erwarteteWelt = game.initDeadWorld();
		boolean[][] gen1 = welt;

		if (game.ruleOneDeathByIsolation(welt, 1, 1)) {
			gen1[1][1] = false;
		}

		assertArrayEquals(gen1, erwarteteWelt);
	}

	@Test
	void regelZweiStribtAnUeberbevoelkerung() {
		welt[0][0] = true;
		welt[2][2] = true;
		welt[0][2] = true;
		welt[2][0] = true;
		welt[1][1] = true;
		erwarteteWelt = welt;
		erwarteteWelt[1][1] = false;
		boolean[][] gen1 = welt;

		if (game.ruleTwoDeathByOverpopulation(welt, 1, 1)) {
			gen1[1][1] = false;
		}

		assertArrayEquals(gen1, erwarteteWelt);
	}

	@Test
	void regelVierWridZumLebenErweckt() {
		welt[0][0] = true;
		welt[2][2] = true;
		welt[0][2] = true;
		welt[1][1] = false;
		erwarteteWelt = welt;
		erwarteteWelt[1][1] = true;
		boolean[][] gen1 = welt;

		if (game.ruleFourReviveThroughNeighbors(welt, 1, 1)) {
			gen1[1][1] = true;
		}

		assertArrayEquals(gen1, erwarteteWelt);
	}
}
