package racingcar.model.game;

public class Game extends GameConfig {
    private boolean isRunning;
    private int raceCount;

    public Game() {
        this.isRunning = true;
        this.raceCount = 0;
    }

    private void end() {
        this.isRunning = false;
    }

    private void input() {
        this.view.inputName();
        try {
            this.player.inputCarNames();
        } catch (IllegalArgumentException exception) {
            this.view.outputError(exception.getMessage());
            this.player.inputCarNames();
        }

        this.view.inputCount();
        try {
            this.player.inputCount();
        } catch (IllegalArgumentException exception) {
            this.view.outputError(exception.getMessage());
            this.player.inputCount();
        }
    }

    private void race() {
        cars.createCarList(this.player.getCarNames());
        this.view.outputRace();
        do {
            cars.race();
            this.raceCount++;
            this.view.outputRaceCars(cars.getCars());
        } while (this.player.getCount() != this.raceCount);
    }

    private void output() {
        this.view.outputResult(this.cars.getWinnners());
    }

    private void run() {
        // 게임 시작 값 입력
        this.input();
        // race 시작
        this.race();
        // 게임 결과 출력
        this.output();
        // 게임 종료
        this.end();
    }

    public void play() {
        do {
            this.run();
        } while (this.isRunning);
    }
}
