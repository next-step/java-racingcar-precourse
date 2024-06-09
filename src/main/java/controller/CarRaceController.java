package controller;

import java.util.List;
import view.InputView;
import view.OutputView;  // OutputView 추후 필요 시 사용

public class CarRaceController {
    public void startRace() {
        try {
            List<String> carNames = InputView.getCarNames();
            // 추후 기능 확장 예정
            // TODO: 경주 시작 로직 추가
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

