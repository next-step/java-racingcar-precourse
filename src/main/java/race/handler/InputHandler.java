package race.handler;

import race.model.Car;

import java.util.Arrays;
import java.util.List;

public class InputHandler {
    private InputHandler() {}

    private static class SingletonHelper {
        private static final InputHandler INSTANCE = new InputHandler();
    }

    public static InputHandler getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public List<Car> inputForCarNameList(String inputCarNameList) {
        List<String> carNameList = splitStringByComma(inputCarNameList);

        return carNameList.stream()
                .map(Car::new)
                .toList();
    }

    private List<String> splitStringByComma(String string) {
        return Arrays.asList(string.split("\\s*,\\s*"));
    }
}
