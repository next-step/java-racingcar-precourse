package racingcar.UI;

import racingcar.domain.CarObject;
import racingcar.domain.RacingCarExeception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class RacingCarUI {
    public static String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public RacingCarUI(){
    }

    /**
     * 사용자 입력 메서드
     * @return 입력받은 buffer
     */
    public String getUserInput(){
        String buffer = Console.readLine();
        return buffer;
    }

    /**
     * 입력받은 buffer를 String array로 변환
     * @param buffer 사용자 입력 buffer
     * @return String array
     */
    public List<String> parseNames(String buffer){
        List<String> result;
        try {
            result = Arrays.asList(buffer.split(","));
        }
        catch (Exception e){
            throw new IllegalStateException(RacingCarExeception.UNKNOWN_PARSE_NAMES_ERROR);
        }
        for (String name: result
             ) {
            verifyLengthOfCarName(name);
        }
        if(result.size()<=1)
            throw new IllegalArgumentException(RacingCarExeception.LACK_NUMBER_OF_CARS_ERROR);
        return result;
    }

    /**
     * 사용자가 입력한 자동차 이름의 길이를 검증하는 메서드
     * @param carName
     */
    private void verifyLengthOfCarName(String carName){
        if(carName.length()>5){
            throw new IllegalArgumentException(RacingCarExeception.EXCEED_LENGTH_OF_NAME_ERROR);
        }
    }

    /**
     * 입력받은 buffer를 Integer로 변환
     * @param buffer
     * @return
     */
    public Integer parseNumber(String buffer){
        Integer result;
        try{
            result = Integer.valueOf(buffer);
        }
        catch (Exception e){
            throw new IllegalArgumentException(RacingCarExeception.INPUT_WRONG_NUMBER_ERROR);
        }
        if(result<=0)
            throw new IllegalArgumentException(RacingCarExeception.INPUT_WRONG_RANGE_ERROR);
        return result;
    }
    public void printCurrentRound(List<CarObject> carsList){
        for (CarObject car: carsList
             ) {
            System.out.println(car);
        }
        System.out.println();
    }
    public void printGameSystemMessage(String buffer){
        System.out.println(buffer);
    }
    public String extractNamesFromCarObjects(List<CarObject> carObjectList){
        List<String> carNames = new ArrayList<>();
        for (CarObject car: carObjectList) {
            carNames.add(car.getCarName());
        }

        return listToString(carNames);
    }
    public String listToString(List<String> carNames){
        String result = "";
        for (String str: carNames) {
            result += ", " + str;
        }
        result = result.substring(2);
        return result;
    }
}
