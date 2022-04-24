package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class CarMoveService {

    private int[] carMoveCount;
    private int moveCount;

    public CarMoveService(String moveCount) {
        this.moveCount = convertStringToInt(moveCount);
    }

    public int[] getCarMoveCount(){
        return carMoveCount;
    }

    private int convertStringToInt(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            new CarMoveService(Console.readLine());
        }
        return i;
    }

    public void move(InputCarService inputCarService) {
        String[] cars = inputCarService.getCarNames();
        carMoveCount = new int[cars.length];
        for (int i = 0; i < moveCount; i++) {
            moveCount(cars.length);
        }
    }

    private void moveCount(int carSize) {
        for (int j = 0; j < carSize; j++) {
            carMoveCount[j] += isMove();
        }
    }

    public int isMove() {
        RandomService randomService = new RandomService();
        if (randomService.getRandomNumber() >= 4) {
            return 1;
        }
        return 0;
    }

}
