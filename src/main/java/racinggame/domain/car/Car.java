package racinggame.domain.car;

public class Car {
    private String carName;
    private int location = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveCar() {
        location++;
    }


    /*private Map<String, Integer> carRepositories;

    public Car(String... carNames) {
        this.carRepositories = new HashMap<>();
        settingMapByCarNames(carNames);
    }

    private void settingMapByCarNames(String[] carNames) {
        for (String carName : carNames) {
            carRepositories.put(carName, 0);
        }
    }

    public void moveCarByNum(String carName, int number) {
        if (isMoveCarByNum(number)) {
            Integer orDefault = carRepositories.getOrDefault(carName, -1);

            carRepositories.put(carName, carRepositories.get(carName) + 1);
        }
    }

    private boolean isMoveCarByNum(int number) {
        return number > 3 && number < 10;
    }*/


}
