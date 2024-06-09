package controller;

import java.util.List;
import view.InputView;
import view.OutputView;

public class CarRaceController {
    public void startRace() {
        try {
            List<String> carNames = InputView.getCarNames();
            int raceCount = InputView.getRaceCount();
            // 추후 기능 확장 예정
            // TODO: 경주 시작 로직 추가
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }
}
