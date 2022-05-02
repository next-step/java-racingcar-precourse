package racingcar;

public class Controller {

    public Controller() {
    }

    public void race() {
        String[] cars = null;

        boolean isValid = false;
        while(!isValid) {
            cars = Cars.inputCars();
            isValid = Cars.checkInput(cars);
        }

        String[] result = new String[cars.length];

        int tryCount = Racing.inputTry();
        for (int i = 0; i < cars.length; i++) {
            result[i] = Racing.moveCar(tryCount);
        }

        for (int j = 0; j < cars.length; j++) {
            System.out.println(cars[j] + " : " + result[j]);
        }
        String winners = Racing.setWinner(cars, result);

        System.out.println("최종 우승자는 "+ winners +" 입니다.");
    }
}
