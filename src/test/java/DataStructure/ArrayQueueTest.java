package DataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

	private ArrayQueue<String> queue;

	@BeforeEach
	void setUp() {
		queue = new ArrayQueue<>();
	}

	@Test
	void illegalArgument() {
		assertThrows(IllegalArgumentException.class, () -> new ArrayQueue<>(-10));
	}

	@Test
	void put() {
		queue.put("Hello");
		assertFalse(queue.isEmpty());
	}

	@Test
	void isEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	void remove() {
	}

	@Test
	void getFrontElement() {
		queue.put("Hello");
		String hello = queue.getFrontElement();
		assertEquals("Hello", hello);
	}

	@Test
	void getRearElement() {
	}
}