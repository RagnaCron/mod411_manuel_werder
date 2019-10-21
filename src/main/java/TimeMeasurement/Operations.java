package TimeMeasurement;

import java.util.Random;

public class Operations {

	private final static Random rand = new Random();

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

	public static Integer[] getRandomIntegerList(int size) {
		Integer[] list = new Integer[size];
		for (int i = 0; i < size; i++)
			list[i] = rand.nextInt();
		return list;
	}


}
