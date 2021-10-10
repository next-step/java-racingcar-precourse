package racinggame.view;

import nextstep.utils.Console;
import racinggame.common.ConstValue;
import racinggame.domain.Cars;
import racinggame.error.InvalidCarNameInput;

public class PlayerInputView {

	public static Cars inputCarName() {

		while(true) {
			try {
				System.out.println(ConstValue.INPUT_CAR_LIST);
				String inputCarName = Console.readLine();

				return Cars.createCars(inputCarName);
			} catch(InvalidCarNameInput e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

