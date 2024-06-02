package race;

import java.util.ArrayList;
import java.util.List;
import validator.CarNameValidator;
import validator.NumberValidator;
import view.Input;
import view.Output;

public class PrepareRace {

    /**
     * 자동차 이름 전처리
     * 앞뒤 공백 무시, 공백 개수 무시
     * @param names
     * @return 전처리 된 자동차 이름
     */
    private List<String> processName(List<String> names) {
        List<String> processedNames = new ArrayList<>();
        for (String name : names) {
            String processedName = name.trim().replaceAll(" +", " ");
            processedNames.add(processedName);
        }

        return processedNames;
    }

    public ArrayList<String>  prepareCar() {
        ArrayList<String> carNames = null;
        boolean isValid = false;
        CarNameValidator carNameValidator = new CarNameValidator();

        while (!isValid) {
            try {
                carNames = Input.getCarNames();
                carNames = (ArrayList<String>) processName(carNames);
                isValid = true;
                carNameValidator.test(carNames);
            } catch (IllegalArgumentException e) {
                Output.printException(e.getMessage());
                isValid = false;
            }
        }
        return carNames;
    }

    public int prepareNumber() {
        String numberString = null;
        boolean isValid = false;
        NumberValidator numberValidator = new NumberValidator();
        while (!isValid) {
            numberString = Input.getNumberAsString();
            try {
                isValid = true;
                numberValidator.test(numberString);
            } catch (IllegalArgumentException e) {
                Output.printException(e.getMessage());
                isValid = false;
            }
        }
        return Integer.parseInt(numberString);
    }
}
