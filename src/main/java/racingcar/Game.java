package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Game {

    public static final int MAX_LENGTH = 5;
    public static final String ERROR_MESSAGE_MAX_LENGTH_EXCEED = "[ERROR]자동차 이름은 5자 이내여야 합니다.";
    public static final String INPUT_MESSAGE_FOR_CARNAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ERROR_MESSAGE_FOR_TIMES = "[ERROR] 시도 횟수는 숫자여야 한다.";
    public static final String INPUT_MESSAGE_FOR_TIMES = "시도할 횟수는 몇회인가요?";
    private RacingCar racingCar;

    void game() {
        readyCars(getInputForNames());
        racing(getInputForTimes());
        List<String> winners = getWinners(convertCars());
        displayResult(getPrizeStatement(winners));
    }

    private void displayResult(String prizeStatement) {
        System.out.println(prizeStatement);
    }

    void racing(int times) {
        System.out.println("실행 결과");
        while(times > 0) {
            racingCar.move();
            times--;
        }
    }

    String getPrizeStatement(List<String> winners) {
        return "최종 우승자: " + String.join(", ", winners);
    }

    PriorityQueue<Car> convertCars() {
        PriorityQueue<Car> carRanks = new PriorityQueue<>();
        carRanks.addAll(racingCar.getCars());
        return carRanks;
    }

    int getHighestPosition(PriorityQueue<Car> ranks) {
        return ranks.peek().getCurrentPosition();
    }

    List<String> getWinners(PriorityQueue<Car> ranks) {
        int highest = getHighestPosition(ranks);
        List<String> winners = new ArrayList<>();
        while(!ranks.isEmpty() && highest == ranks.peek().getCurrentPosition()) {
            winners.add(ranks.poll().getName());
        }
        return winners;
    }

    List<String> getInputForNames() {
        String nameSource;
        List<String> carNames = null;
        do{
            nameSource = getNames();
            carNames = new ArrayList<>();
            for(String name : nameSource.split(",")) {
                carNames.add(name);
            }
        }while(!isValidCarName(nameSource));

        return carNames;
    }

    boolean isValidCarName(String carNameSource) {
        try {
            List<String> carNames = Arrays.asList(carNameSource.split(","));
            isLengthExceed(carNames);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void isLengthExceed(List<String> carNames) {
        for (String carName : carNames) {
            lengthCheck(carName);
        }
    }

    private void lengthCheck(String carName) {
        if(carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MAX_LENGTH_EXCEED);
        }
    }

    private void readyCars(List<String> carNames) {
        this.racingCar = new RacingCar(carNames);
    }

    private String getNames() {
        System.out.println(INPUT_MESSAGE_FOR_CARNAME);
        return Console.readLine();
    }

    int getInputForTimes() {
        return getTimes();
    }

    private int getTimes() {
        System.out.println(INPUT_MESSAGE_FOR_TIMES);
        try{
            int times = Integer.valueOf(Console.readLine());
            return times;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_TIMES);
        }
    }

}
