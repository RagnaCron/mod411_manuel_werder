package DataStructure;

public class ArrayQueue<T> implements Queue<T> {

	private int front, rear;

	private T[] queue;

	public ArrayQueue() {
		this(10);
	}

	public ArrayQueue(int capacity) {
		if (capacity < 1)
			throw new IllegalArgumentException("Capacity must be >= 1");
		queue = (T[]) new Object[capacity];
		front = 0;
		rear = 0;
	}

	@Override
	public void put(T payload) {
		queue[rear++] = payload;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public T remove() {
		return null;
	}

	@Override
	public T getFrontElement() {
		return queue[front];
	}

	@Override
	public T getRearElement() {
		return null;
	}
}
