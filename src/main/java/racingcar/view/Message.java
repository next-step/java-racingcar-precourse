package racingcar.view;

import racingcar.Car;
import racingcar.Cars;

public class Message {
    public static final String PLAY_RESULT_MESSAGE = "실행 결과";
    public static final String DRIVE_MARK = "-";
    public static final String NAME_DRIVE_SEPARATION = " : ";
    public static final String FINAL_WINNER_LIST = "최종 우승자: ";
    public static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    public static final String REQUEST_GAME_ROUNDS = "시도할 회수는 몇회인가요";

    public void playResult() {
        System.out.println();
        System.out.println(PLAY_RESULT_MESSAGE);
    }

    public void roundsMessgae(Cars cars) {
        for(Car car : cars.cars) {
            StringBuilder roundsMessage = new StringBuilder();

            roundsMessage.append(car.getCarName() + NAME_DRIVE_SEPARATION + appendDrive(car.getCarPosition()));
            System.out.println(roundsMessage.toString());
        }

        System.out.println();
    }

    private String appendDrive(int driveCount) {
        StringBuilder driveMessage = new StringBuilder();
        for(int i = 0; i < driveCount; i++) driveMessage.append(DRIVE_MARK);

        return driveMessage.toString();
    }

    public void finalWinner(String finalWinnerList) {
        System.out.println(FINAL_WINNER_LIST + finalWinnerList);
    }

    public void requestCarsName() {
        System.out.println(REQUEST_CARS_NAME);
    }

    public void requestGameRounds() {
        System.out.println(REQUEST_GAME_ROUNDS);
    }

    public void error(String errorDetail) {
        System.out.println(errorDetail);
    }
}
