package GameOfLifeSimulationTests;

import GameOfLifeSimulation.GameOfLife;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class GameOfLifeTest {

	GameOfLife game;
	boolean[][] welt;

	@BeforeEach
	void setup() {
		game = new GameOfLife(3, 3);
		welt = game.initToteWelt();
	}


	@Test
	void regelEinsStibtAnEinsamkeit() {
		welt[1][1] = true;
		boolean[][] erwarteteWelt = game.initToteWelt();
		boolean[][] gen1 = welt;

		if (game.regelEinsStibtAnEinsamkeit(welt, 1, 1)) {
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
		boolean[][] erwarteteWelt = welt;
		erwarteteWelt[1][1] = false;
		boolean[][] gen1 = welt;

		if (game.regelZweiStribtAnUeberbevoelkerung(welt, 1, 1)) {
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
		boolean[][] erwarteteWelt = welt;
		erwarteteWelt[1][1] = true;
		boolean[][] gen1 = welt;

		if (game.regelVierWirdZumLebenErweckt(welt, 1, 1)) {
			gen1[1][1] = true;
		}

		assertArrayEquals(gen1, erwarteteWelt);
	}
}
