package racingcar;

import java.util.*;

public class RacingCar {
    private static InputOutput io = new InputOutput();
    private static List<Car> carList = new ArrayList<>();
    private static Message message;

    private static int MAX_VALUE = Integer.MIN_VALUE;
    private static int attemptsCount;

    public RacingCar() {
        List<String> carNameList = new ArrayList<>();
        input();
    }

    public void run() {
        play();
        result();
    }

    public void play() {
        for (int i = 0; i < attemptsCount; i++) {
            turn();
        }
    }

    public void result() {
        Collections.sort(carList);
        String resultName = carList.get(0).getName();
        MAX_VALUE = carList.get(0).getPositionIndex();
        for (int i = 1; i < carList.size(); i++) {
            resultName = winCar(carList.get(i), resultName);
        }

        io.print(resultName + message.WIN_MESSAGE);
    }

    public String winCar(Car car, String resultName) {
        if (MAX_VALUE == car.getPositionIndex()) {
            resultName += ", " + car.getName();
        }

        return resultName;
    }

    public void turn() {
        io.print(message.GAME_RESULT);
        for (int i = 0; i < carList.size(); i++) {
            io.print(carList.get(i).getName() + " : " + carList.get(i).move(GoStop.getRandomNumber()));
        }
        io.print("");
    }

    public static void initCar(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            carList.add(new Car(carNameList.get(i)));
        }
    }

    public static List<String> separateName(String input) {
        List<String> carNameList = Arrays.asList(input.split(","));
        for (String name : carNameList) {
            limitName(name);
        }

        return carNameList;
    }

    public static boolean checkLen(String carName) {
        if (carName.length() <= 5) {
            return true;
        }
        return false;
    }

    public static void input() {
        io.print(message.INPUT_CAR_NAME);
        List<String> carNameList = separateName(io.input());
        io.print(message.ATTEMPT_COUNT);
        attemptsCount = Integer.parseInt(io.input());

        initCar(carNameList);
    }

    public static void limitName(String carName) {
        if(carName.length() > 5 || carName.length() <= 0) {
            throw new IllegalArgumentException(message.CAR_NAME_5_MORE_THAN_ERROR);
        }
    }
}
