package racinggame.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;

public class Racing {

    public static final int MOVE_FORWARD_MIN_NUM = 4;
    public static final int MOVE_FORWARD_MAX_NUM = 9;

    public static int START_INCLUSIVE = 1;
    public static int END_INCLUSIVE = 9;

    public static ArrayList<Car> recordingRaceList = new ArrayList<Car>();

    public static void racingByRound(ArrayList<Car> carList, int roundCnt) {
        for(int i = 1; i <= roundCnt; i++) { //1 round
            racingAllCars(carList);
            System.out.println(" :: [" + i + "] Round 종료 :: " );
            lineSeparator();
        }
    }

    public static ArrayList<Car> racingAllCars(ArrayList<Car> carList) {
        for(int i = 0; i < carList.size(); i++) {
            moveFowardOrStay(carList.get(i), getRandomNumbers());
            visualizeNowPosition(carList.get(i).confirmCarName(), carList.get(i).confirmNowPosition());
        }
        recordNowCar(carList);
        return carList;
    }

    private static void visualizeNowPosition(String nowCarName, int nowCarPosition) {
        String ast = " * ";
        System.out.print("현재 진행중인 차량 [" + nowCarName + "] 의 현재 위치 : ");
        for(int i = 0; i < nowCarPosition; i++) {
            System.out.print(ast);
        }
        lineSeparator();
    }

    private static void recordNowCar(ArrayList<Car> car) {
        recordingRaceList.addAll(car);
    }

    private static int getRandomNumbers() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public static void moveFowardOrStay(Car car, int randomNumber) {
        if(validateMoveFoward(randomNumber)) {
            System.out.println("[" + car.confirmCarName() + "] 차량 이동 합니다.");
            car.moveForward();
        }
    }

    public static boolean validateMoveFoward(int inputNumber) {
        return inputNumber >= MOVE_FORWARD_MIN_NUM && inputNumber <= MOVE_FORWARD_MAX_NUM;
    }

    private static void lineSeparator() {
        System.out.println(" ");
    }
}
