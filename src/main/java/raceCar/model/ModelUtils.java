package raceCar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelUtils {
	public static int getRandomNumber() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <= 9; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return numbers.get(0);
	}
}
