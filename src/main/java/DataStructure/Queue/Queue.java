package DataStructure.Queue;

public interface Queue<T> {

	public int size();

	public void put(T payload);

	public boolean isEmpty();

	public T remove();

	public T getFrontElement();

	public T getRearElement();


}
