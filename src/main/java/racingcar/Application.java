package racingcar;

public class Application {
    public static void main(String[] args) {
        // 사용자에게 입력을 받는 부분
        InputView inputView = new InputView();

        String[] carNames = null;
        int tryCount = 0;

        // Car 이름 입력받기
        while (carNames == null) {
            try {
                carNames = inputView.getCarNames();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        // 총 시도횟수 입력받기
        while (tryCount == 0) {
            try {
                tryCount = inputView.getTryCount();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        Race race = new Race(carNames, tryCount);
        race.start();

        System.out.println(race.getWinners());
    }
}
