package racingcar.application.io;

import java.util.ArrayDeque;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.History;

public class Output {

    public void printCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printRoundInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult(History history) {
        System.out.println("\n실행 결과");

        List<Cars> carsList = history.cars();

        StringBuilder sb = new StringBuilder();
        for (Cars cars : carsList) {
            printCars(sb, cars);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public void printWinners(Cars winners) {
        ArrayDeque<String> queue = new ArrayDeque<>(winners.carNames());

        StringBuilder sb = new StringBuilder(queue.removeFirst());
        while (!queue.isEmpty()) {
            sb.append(", ").append(queue.removeFirst());
        }

        System.out.println(String.format("최종 우승자 : %s", sb));
    }

    private void printCars(StringBuilder sb, Cars cars) {
        for (Car car : cars.cars()) {
            sb.append(car.nameValue()).append(" : ");
            sb.append(createPositionDash(car.positionValue()));
            sb.append("\n");
        }
    }

    private String createPositionDash(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
