public class RacingInputHandler {
    public static String[] splitCarNames(String carNames) throws IllegalArgumentException {
        String[] cars = carNames.split(",");;

        for (int i = 0; i < cars.length; i++) {
            cars[i] = cars[i].trim();
            if (cars[i].length() > 5) {
                throw new IllegalArgumentException(cars[i] + " - 자동차의 이름이 5자를 초과함.");
            }
        }
        return cars;
    }
}
