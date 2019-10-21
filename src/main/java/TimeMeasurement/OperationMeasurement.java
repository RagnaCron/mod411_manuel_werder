package TimeMeasurement;

import java.util.function.Consumer;

public class OperationMeasurement {

	public static <T> String measureRuntime(Consumer<T> function, T list) {
		long startTime = System.nanoTime();
		function.accept(list);
		long stopTime = System.nanoTime();
		return String.format("runtime: %6d ms", (stopTime - startTime) / Operations.MILLION);
	}

}
