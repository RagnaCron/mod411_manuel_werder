package TimeMeasurement;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

@SuppressWarnings("all")
public class Operations {

	private final static Random rand = new Random();
	private final static Supplier<Integer> supplie = () -> rand.nextInt();

	private final static String[] ABC_LIST = {
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
			"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "<", ".", ":",
			",", ";", "-", "_", "{", "}", "[", "]", "+", "¦", "@", "*", "#",
			"%", "&", "°", "¬", "/", "|", "(", "¢", ")", "=", "'", "?", "´",
			"^", "`", "~", "!", "¨", "$", "£", ">", "\\"
	};

	public final static int THOUSAND = 1000;
	public final static int TEN_THOUSAND = 10_000;
	public final static int HUNDRED_THOUSAND = 100_000;
	public final static int MILLION = 1_000_000;
	public final static int TEN_MILLION = 10_000_000;

	public static String[] getRandomStringList(int size) {
		String[] list = new String[size];
		for (int i = 0; i < size; i++)
			list[i] = ABC_LIST[rand.nextInt(ABC_LIST.length)];
		return list;
	}

	public static String[] getRandomIntegerStringList(int size) {
		String[] list = new String[size];
		for (int i = 0; i < size; i++)
			list[i] = String.valueOf(rand.nextLong());
		return list;
	}

	public static Integer[] getRandomIntegerArray(int size) {
		Integer[] list = createIntegerArray(size);
		for (int i = 0; i < size; i++)
			list[i] = rand.nextInt();
		return list;
	}

	public static ArrayList<Integer> getRandomIntegerArrayList(int size) {
		ArrayList<Integer> integers = createIntegerArrayList(size);
		for (int i = 0; i < size; i++)
			integers.add(rand.nextInt());
		return integers;
	}

	public static Integer[] createIntegerArray(int size) {
		return new Integer[size];
	}

	public static ArrayList<Integer> createIntegerArrayList(int size) {
		return new ArrayList<>(size);
	}

	public static void insertIntoStaticArray(Integer[] array) {
		for (int i = 0; i < array.length; i++)
		    array[i] = rand.nextInt();
	}

	public static void insertIntoArrayList(int size) {
		ArrayList<Integer> arrayList = new ArrayList<>(size);
		for (int i = 0; i < size; i++)
			arrayList.add(rand.nextInt());
	}

	public static void deleteFromArrayListFront(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++)
			list.remove(i);
	}

	public static void deleteFromArrayListBack(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--)
			list.remove(i);
	}

}
