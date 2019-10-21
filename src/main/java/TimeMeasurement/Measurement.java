package TimeMeasurement;

import java.util.function.Consumer;

public class Measurement {

	public static <T> String measureRuntime(Consumer<T> function, T list) {
		long startTime = System.nanoTime();
		function.accept(list);
		long stopTime = System.nanoTime();
		return String.format("%6d ms", (stopTime - startTime) / Operations.MILLION);
	}

}
