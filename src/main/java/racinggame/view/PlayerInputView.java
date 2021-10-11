package racinggame.view;

import nextstep.utils.Console;
import racinggame.common.ConstValue;
import racinggame.domain.Cars;
import racinggame.domain.boxing.Round;
import racinggame.error.InvalidCarNameInput;
import racinggame.error.InvalidGameRoundInput;

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

	public static Round inputGameCount() {
		try {
			System.out.println(ConstValue.INPUT_ROUND_COUNT);
			String inputGameCount = Console.readLine();

			return new Round(inputGameCount);
		} catch(InvalidGameRoundInput e) {
			System.out.println(e.getMessage());
			return inputGameCount();
		}
	}
}

