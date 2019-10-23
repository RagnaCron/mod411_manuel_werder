package DataStructure;

public interface Queue<T> {

	public void put(T payload);

	public boolean isEmpty();

	public T remove();

	public T getFrontElement();

	public T getRearElement();


}
