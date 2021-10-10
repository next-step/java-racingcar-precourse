package racinggame.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;
import racinggame.utils.ParseUtils;

public class InputView {

	private InputView() {
	}

	public static List<String> getCarNamesInput() {
		return new ArrayList<>(Arrays.asList(ParseUtils.parseByComma(Console.readLine())));
	}

	public static int getTryCountInput() {
		return ParseUtils.parseInt(Console.readLine());
	}

}
