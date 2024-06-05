package controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import service.CarServiceInterface;
import service.RaceServiceInterface;
import view.RaceViewInterface;

public class RaceController implements RaceControllerInterface {

    private RaceServiceInterface race;
    private RaceViewInterface view;

    @Override
    public void init() {

    }

    @Override
    public void play() {

    }

    @Override
    public void end() {

    }

    // view에서 입력으로 들어온 차를 생성하도록 race에 전달
    @Override
    public void addCars(String[] cars) {
        try {
            // 생성 시도
            race.addCars(cars);
        } catch (IllegalArgumentException e) {
            // 5글자를 넘은 경우, error 메시지를 출력하고
            view.printCarsErrorMessage(e.getMessage());
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
