package view;

import controller.RaceControllerInterface;
import java.util.ArrayList;
import java.util.Scanner;
import observer.Observer;
import service.CarServiceInterface;
import service.RaceServiceInterface;

public class RaceView implements Observer, RaceViewInterface {

    // View가 참조할 Service와 Controller. 조작은 절대 금지.
    private RaceServiceInterface raceServiceInterface;
    private RaceControllerInterface raceControllerInterface;

    // 생성자
    public RaceView(RaceServiceInterface raceServiceInterface,
        RaceControllerInterface raceControllerInterface) {
        this.raceServiceInterface = raceServiceInterface;
        this.raceControllerInterface = raceControllerInterface;
    }

    // 옵저버 패턴에서 옵저버가 갖는 메서드
    @Override
    public void update() {
        // update가 발생했으면 즉시 출력
        printProgress();
    }

    // 자동차 이름을 입력받는 메서드
    @Override
    public void userCarsInput() {
        // 안내문 출력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        // 유저의 입력을 받고 token으로 쪼개기
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String[] cars = userInput.split(",");

        // Controller에게 유저의 입력을 전달
        raceControllerInterface.addCars(cars);
    }

    // 사용자의 횟수를 입력받는 메서드
    @Override
    public void userRoundsInput() {
        // 안내문 출력
        System.out.println("시도할 횟수는 몇 회인가요? (100회 이하만 가능합니다.)");

        // 유저의 입력을 받기
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        // Controller에게 유저의 입력을 전달
        raceControllerInterface.setRound(userInput);
    }

    // 한 번 진행의 결과를 보여주는 메서드
    @Override
    public void printProgress() {
        // raceService를 통해 차 목록을 받아와서
        RaceServiceInterface raceService = raceServiceInterface;
        ArrayList<CarServiceInterface> carList = raceService.getCars();
        // stream을 이용하여 양식에 맞게 출력
        carList.stream().forEach(car -> System.out.println(car.getName() + " : " + car.getProgress()));
        System.out.println();
    }

    // 전체 과정을 담당하는 메서드
    @Override
    public void printProcess() {

    }

    @Override
    public void printResult() {

    }

    @Override
    public void printCarsErrorMessage() {

    }

    @Override
    public void printRoundsArgumentErrorMessage() {

    }

    @Override
    public void printRoundsFormatErrorMessage() {

    }
}
