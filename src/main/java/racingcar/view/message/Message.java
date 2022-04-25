package racingcar.view.message;

import java.util.List;

public class Message {

    public String resultTitle() {
        return "실행 결과";
    }

    public String moveDistance(String carName, Distance distance) {
        return String.format("%s : %s", carName, distance.get());
    }

    public String inputCarsNames() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    public String inputMoveCount() {
        return "시도할 회수는 몇회인가요?";
    }

    public String winners(List<String> names) {
        final String winners = String.join(", ", names);
        return String.format("최종 우승자: %s", winners);
    }

    public String error(String message) {
        return String.format("[ERROR]: %s", message);
    }
}
