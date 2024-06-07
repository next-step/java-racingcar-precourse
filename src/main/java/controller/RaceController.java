package controller;

import service.RaceServiceInterface;
import view.RaceViewInterface;

public class RaceController implements RaceControllerInterface {

    private RaceServiceInterface race;
    private RaceViewInterface view;

    // 생성자
    public RaceController(RaceServiceInterface race, RaceViewInterface view) {
        this.race = race;
        this.view = view;
    }

    // 시작 단계에서 호출하는 메서드
    @Override
    public void init() {
        view.userCarsInput();
        view.userRoundsInput();
    }

    // 중간 단계에서 호출하는 메서드
    @Override
    public void play() {
        view.printProcess();
        race.startRace();
    }

    // 마무리 단계에서 호출하는 메서드
    @Override
    public void end() {
        view.printResult();
    }

    // view에서 입력으로 들어온 차를 생성하도록 race에 전달
    @Override
    public void addCars(String[] cars) {
        try {
            // 생성 시도
            race.addCars(cars);
        } catch (IllegalArgumentException e) {
            // 5글자를 넘은 경우, error 메시지를 출력하고
            view.printCarsErrorMessage();
            // 다시 view에 입력을 요청
            view.userCarsInput();
        }
    }

    // view에서 입력으로 들어온 횟수를 저장하도록 race에 전달
    @Override
    public void setRound(String numberOfRound) {
        // 전달 시도
        try {
            race.setNumberOfRounds(numberOfRound);
        } catch (NumberFormatException e) {
            // 숫자가 아닌 경우, error 메시지를 출력
            view.printRoundsFormatErrorMessage();
            // 다시 view에 입력을 요청
            view.userRoundsInput();
        } catch (IllegalArgumentException e) {
            // 숫자가 너무 큰 경우, error 메시지를 출력
            view.printRoundsArgumentErrorMessage();
            // 다시 view에 입력을 요청
            view.userRoundsInput();
        }
    }
}
