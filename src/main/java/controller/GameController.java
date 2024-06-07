package controller;

import java.util.List;
import model.Car;
import service.GameService;
import view.GameView;

public class GameController {
    private GameView view;
    private GameService service;
    private List<Car> cars;
    private int numberOfMoves;

    /**
     * GameController 생성자
     *
     * @param view GameView
     * @param service GameService
     */
    public GameController(GameView view, GameService service) {
        this.view = view;
        this.service = service;
    }

    /**
     * 사용자 기본 입력을 받는 게임 초기화 메서드
     */
    public void initializeGame() {
        List<String> carNames = getValidCarNames();
        cars = service.createCarObject(carNames);
        numberOfMoves = view.getNumberOfMoves();
    }

    /**
     * 사용자의 자동차 이름 입력을 받을 때, valid value만을 받도록 검증하는 메서드
     *
     * @return 검증된 carNames
     */
    private List<String> getValidCarNames() {
        while(true) {
            try {
                List<String> carNames = view.getCarNames();
                service.createCarObject(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
            }
        }
    }

    /**
     * 게임 진행 메서드
     */
    public void playGame() {
        view.printResultMessage();
        for(int i = 0; i < numberOfMoves; i++) {
            service.moveCars(cars);
            view.printCarPosition(cars);
        }
    }

    /**
     * 게임의 결과(최종 우승자)를 출력하는 메서드
     */
    public void printResult() {
        view.printWinners(service.findWinners(cars));
    }

    /**
     * main에서 호출하기 위한 게임 시작 메서드
     */
    public void startGame() {
        initializeGame();
        playGame();
        printResult();
    }
}
