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
        ArrayList<Car> racingList = carList;
        for(int i = 0; i < roundCnt; i++) { //1 round
            racingList = racingAllCars(racingList);
        }
    }

    private static ArrayList<Car> updateEveryRound(ArrayList<Car> racingList) {
        for(int i = 0; i < racingList.size(); i++) {
            racingList.set(i, racingList.get(i));
        }
        return racingList;
    }

    public static ArrayList<Car> racingAllCars(ArrayList<Car> carList) {
        for(int i = 0; i < carList.size(); i++) {
            moveFowardOrStay(carList.get(i), getRandomNumbers());
//            recordNowCar(carList.get(i));
        }
        recordNowCar(carList);
        return carList;
    }

    private static void recordNowCar(ArrayList<Car> car) {
        for(int i =0; i<car.size(); i ++){
            recordingRaceList.add(car.get(i));
        }

        for(int i =0; i<recordingRaceList.size(); i ++){
            System.out.println(" :: " + recordingRaceList.get(i).confirmCarName() + " + " + recordingRaceList.get(i).confirmNowPosition() + " :: ");
        }
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
}
