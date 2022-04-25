package view;

import camp.nextstep.edu.missionutils.Console;
import exception.ExceptionWrapper;
import model.Car;

import java.util.List;
import java.util.NoSuchElementException;

public class CarRacingView {

    private final static String READ_JOIN_CAR_LIST_MENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String READ_ACCEL_COUNT_MENT = "시도할 회수는 몇회인가요?";
    private final static String RESULT_MENT = "실행 결과";
    private final static String WINNER_MENT = "최종 우승자: ";

    public static String readJoinCarList(){
            System.out.println(READ_JOIN_CAR_LIST_MENT);
            String input = Console.readLine();
            return input;
    }

    public static String readAccelCount() {
            System.out.println(READ_ACCEL_COUNT_MENT);
            String input = Console.readLine();
            return input;
    }

    public static void showResult(List<Car> joinCarList) {
        System.out.println(RESULT_MENT);
        int recordCount = readRecordCount(joinCarList);
        showResult(joinCarList, 0, recordCount);
    }

    private static void showResult(List<Car> joinCarList, int startTime,  int endTime) {
        for(Car car : joinCarList){
            String carName = car.getCarName();
            int accelCount = car.readBlackBox(startTime, endTime);
            printResult(carName, accelCount);
        }
        System.out.println();
    }

    private static void printResult(String carName, int accelCount) {
        System.out.println(carName + " : " + getLocation(accelCount));
    }

    private static String getLocation(int accelCount) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < accelCount; i++){
            sb.append("-");
        }
        return sb.toString();
    }

    private static int readRecordCount(List<Car> joinCarList) {
        Car car = joinCarList.get(0);
        return car.readBlackBoxRecordSize();
    }

    public static void showWinner(List<Car> winnerList) {
        System.out.println(WINNER_MENT + getStrWinner(winnerList));
    }

    private static String getStrWinner(List<Car> winnerList) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(Car car : winnerList){
            if(index>0)
                sb.append(", ");
            sb.append(car.getCarName());
            index++;
        }
        return sb.toString();
    }
}
