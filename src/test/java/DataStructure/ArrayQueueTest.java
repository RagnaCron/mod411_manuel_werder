package DataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

	private ArrayQueue<String> queue;

	@BeforeEach
	void setUp() {
		queue = new ArrayQueue<>(2);
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
		queue.put("Hello");
		String hello = queue.remove();
		assertEquals("Hello", hello);
		assertTrue(queue.isEmpty());
	}

	@Test
	void getFrontElement() {
		queue.put("Hello");
		String hello = queue.getFrontElement();
		assertEquals("Hello", hello);
	}

	@Test
	void getRearElement() {
		queue.put("Hello");
		String hello = queue.getRearElement();
		assertEquals("Hello", hello);
	}

	@Test
	void runQueue() {
		queue.put("Hello");
		queue.put("world");
		assertEquals("Hello", queue.getFrontElement());
		assertEquals("world", queue.getRearElement());
		assertEquals("Hello", queue.remove());
		assertEquals("world", queue.remove());
		assertTrue(queue.isEmpty());
		queue.put("Hello");
		assertFalse(queue.isEmpty());
		
	}

}