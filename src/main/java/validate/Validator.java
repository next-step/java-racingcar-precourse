package validate;

import java.util.Arrays;

public class Validator {

    public boolean validateRaceInput(String raceInput, char symbol, int carNameNum){
        validateCarCount(raceInput, symbol);
        validateDuplicateCarName(raceInput, symbol);
        validateUnderCarNum(raceInput, symbol, carNameNum);
        return true;
    }
    private void validateCarCount(String raceInput, char symbol) {
        long carCount = raceInput.chars()
            .filter(letter -> letter == symbol)
            .count();

        if (carCount < 1){
            throw new IllegalStateException("[ERROR] 경주는 두 명 이상일 때 할 수 있습니다.");
        }
    }

    private void validateDuplicateCarName(String raceInput, char symbol) {
        String[] carList = raceInput.split(Character.toString(symbol));
        long distinctCarCount = Arrays.stream(carList).distinct().count();
        long totalCarCount = carList.length;
        if(distinctCarCount != totalCarCount){
            throw new IllegalArgumentException("[ERROR] 중복된 자동차의 이름이 있습니다.");
        }
    }

    private void validateUnderCarNum(String raceInput, char symbol, int carNameNum) {
        String[] carList = raceInput.split(Character.toString(symbol));
        for (String carName : carList){
            if(carName.length() > carNameNum){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하만 가능합니다. 이름 초과 : " + carName);
            }
        }
    }

    public boolean validateRaceCount(String raceNum) {
        validateIsNum(raceNum);
        validateUnderRaceNum(raceNum);
        return true;
    }

    private void validateIsNum(String raceNum) {
        for (char c : raceNum.toCharArray()){
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
            }
        }
    }

    private void validateUnderRaceNum(String raceNum) {
        int intRaceNum = Integer.parseInt(raceNum);
        if (intRaceNum < 2){
            throw new IllegalArgumentException("[ERROR] 2이상의 숫자만 입력할 수 있습니다.");
        }
    }
}
