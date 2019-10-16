package GameOfLifeSimulationTests;

import GameOfLifeSimulation.GameOfLife;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

	GameOfLife game;
	boolean[][] welt;

	@BeforeEach
	void setup() {
		game = new GameOfLife(9, 9);
		welt = game.initWelt();
	}


	@Test
	void regelEinsStibtAnEinsamkeit() {

	}

	@Test
	void regelZweiStribtAnUeberbevoelkerung() {
	}

	@Test
	void regelVierWridZumLebenErweckt() {
	}
}
