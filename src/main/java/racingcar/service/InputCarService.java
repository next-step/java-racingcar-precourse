package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class InputCarService {

    private String[] carNames;

    public InputCarService(String input) {
        carNames = splitStrings(input);
        validStringLength();
    }

    public String[] getCarNames() {
        return carNames;
    }

    public String[] splitStrings(String input) {
        return input.split(",");
    }

    public void validStringLength() {
        for (int i = 0; i < carNames.length; i++) {
            validStringLength(i);
        }
    }

    private void validStringLength(int index) {
        try {
            validDownNumberSix(carNames[index]);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            carNames[index] = Console.readLine();
            validStringLength();
        }
    }

    public void validDownNumberSix(String carName) {
        if (carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
