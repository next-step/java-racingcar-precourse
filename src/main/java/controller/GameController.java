package controller;

import model.CarDTO;
import model.GameDTO;
import view.InputView;

import java.util.List;

public class GameController {
    private GameDTO gameDTO;

    // TODO: 입력받은 이름을 토대로 자동차 객체 생성하기
    public GameController(String[] carNames) {
        this.gameDTO = new GameDTO(InputView.inputGameIteration(), carNames);
    }

    public void play() {

    }

}
