package racinggame.model;

import nextstep.utils.Randoms;

public class Racing {
    private static Cars cars;
    private static int tryNum;

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public int getTryNum() {
        return tryNum;
    }

    public void setTryNum(int tryNum) {
        this.tryNum = tryNum;
    }

    public static int getRandom() {
        return Randoms.pickNumberInRange(1,9);
    }

    public static MoveStatus goOrStop(int val) {
        if(val > 4) {
            return MoveStatus.GO;
        }
        return MoveStatus.STOP;
    }

    public static void moveGo(Car car) {
        if(goOrStop(getRandom()) == MoveStatus.GO) {
            car.setScore(car.getScore() + 1);
        }
    }

    public static void playOneCycle(Cars cars) {
        for(Car car : cars.getCars()) {
            moveGo(car);
        }
    }

    public static void makeCarsByInputName(String inputNames) {
        cars.setCars(cars.makeCarsByInputName(inputNames));
    }

    public static String getWinner(Cars cars) {
        int maxScore = 0;
        String winner = "";

        for(Car car : cars.getCars()) {
            maxScore = maxScore > car.getScore() ? maxScore : car.getScore();
        }

        for(Car car : cars.getCars()) {
            if(car.getScore() == maxScore) {
                winner += car.getName() + ",";
            }
        }

        return winner.substring(0, winner.length()-1);
    }

}
