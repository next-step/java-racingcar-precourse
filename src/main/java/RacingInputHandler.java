public class RacingInputHandler {
    public static String[] splitCarNames(String carNames) throws IllegalArgumentException {
        String[] cars = carNames.split(",");

        for (int i = 0; i < cars.length; i++) {
            cars[i] = cars[i].trim();

            if (cars[i].length() > 5) {
                throw new IllegalArgumentException(cars[i] + " - 자동차의 이름이 5자를 초과함.");
            }

            if (cars[i].length() <= 0) {
                throw new IllegalArgumentException("유효하지 않은 자동차 이름이 포함되어 있음.");
            }
        }

        return cars;
    }

    public static int tryCntToInt(String tryCnt) {
        tryCnt = tryCnt.trim();

        if (!tryCnt.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        }

        int num = Integer.parseInt(tryCnt);
        if (num > 1000) {
            throw new IllegalArgumentException("너무 많은 시도 횟수를 입력하셨습니다. 시도 횟수는 1000 이하여야 합니다.");
        }

        return num;
    }
}
