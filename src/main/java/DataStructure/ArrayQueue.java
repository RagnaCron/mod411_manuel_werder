package DataStructure;

public class ArrayQueue<T> implements Queue<T> {

	private int front, rear;

	private T[] queue;

	public ArrayQueue() {
		this(10);
	}

	public ArrayQueue(int capacity) {
		if (capacity < 2)
			throw new IllegalArgumentException("Capacity must be >= 2");
		queue = (T[]) new Object[capacity];
		front = 0;
		rear = 0;
	}

	@Override
	public void put(T payload) {
		queue[rear] = payload;
		rear = queue.length - 1 == rear ? rear % (queue.length - 1) : rear + 1;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public T remove() {
		T item =  queue[front];
		front = queue.length - 1 == front ? front % (queue.length - 1) : front + 1;
		return item;
	}

	@Override
	public T getFrontElement() {
		return queue[front];
	}

	@Override
	public T getRearElement() {
		return queue[Math.abs(rear - 1)];
	}
}
