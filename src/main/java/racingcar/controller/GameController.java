package racingcar.controller;


import java.util.List;
import java.util.Objects;
import racingcar.model.Car;
import racingcar.model.Parser;
import racingcar.model.Participants;
import racingcar.model.Turn;
import racingcar.view.GameView;

public class GameController {

    private final Turn turn;
    private final Parser parser;
    private final GameView gameView;
    private final Participants participants;

    /**
     * 게임 컨트롤러 내부 생성자
     *
     * @param gameControllerBuilder 게임 컨트롤러 생성 빌더
     */
    public GameController(GameControllerBuilder gameControllerBuilder) {
        this.turn = new Turn();
        this.participants = new Participants();
        this.parser = gameControllerBuilder.parser;
        this.gameView = gameControllerBuilder.gameView;
    }

    /**
     * 게임 컨트롤러 셋팅 함수
     */
    public void init() {
        setParticipantsUntilComplete();
        setTurnUntilComplete();
    }

    /**
     * 유효한 turn이 들어올때까지 입력을 받아 Turn 객체에 set 해주는 함수
     */
    private void setTurnUntilComplete() {
        while (Objects.isNull(turn.getValue())) {
            turn.setValue(parser.parseTurn(gameView.queryTurnCount()));
        }
    }

    /**
     * 유효한 이름이 들어올때까지 입력을 받아 Participants 객체에 set 해주는 함수
     */
    private void setParticipantsUntilComplete() {
        while (participants.getCars().isEmpty()) {
            participants.setCarsByNames(parser.parseName(gameView.queryCarName()));
        }
    }

    /**
     * 게임 컨트롤러 실행 함수
     */
    public void run() {

        for (int i = 0; i < turn.getValue(); i++) {
            participants.progressStage();
            printGameProgress(participants.getCars());
            System.out.println();
        }
        List<String> winners = participants.getWinner();
        gameView.printEnding(winners);
    }

    /**
     * 현재 상황 출력 함수
     *
     * @param cars 현재 게임에서의 참가 자동차 리스트
     */
    public void printGameProgress(List<Car> cars) {
        cars.forEach(car -> gameView.printCarLocation(car.getName(), car.getLocation()));
    }

    public static class GameControllerBuilder {

        private GameView gameView;

        private Parser parser;

        public GameControllerBuilder gameView(GameView gameView) {
            this.gameView = gameView;
            return this;
        }

        public GameControllerBuilder parser(Parser parser) {
            this.parser = parser;
            return this;
        }

        public GameController build() {
            return new GameController(this);
        }
    }
}