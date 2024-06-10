package view;

import controller.RaceControllerInterface;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import model.CarModelInterface;
import observer.Observer;
import service.RaceServiceInterface;

public class RaceView implements Observer, RaceViewInterface {

    // View가 참조할 Service와 Controller. 조작은 절대 금지.
    private RaceServiceInterface raceServiceInterface;
    private RaceControllerInterface raceControllerInterface = null;

    // 생성자
    public RaceView(RaceServiceInterface raceServiceInterface) {
        this.raceServiceInterface = raceServiceInterface;
    }

    // setter
    public void setRaceControllerInterface(RaceControllerInterface raceControllerInterface) {
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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

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

    // progress를 받으면 막대기로 돌려주는 메서드
    private String getProgressBar(int progress) {
        // 빠른 처리를 위한 Stringbuilder
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, progress).forEach(i -> stringBuilder.append('-'));

        return stringBuilder.toString();
    }

    // 한 번 진행의 결과를 보여주는 메서드
    @Override
    public void printProgress() {
        // raceService를 통해 차 목록을 받아와서
        RaceServiceInterface raceService = raceServiceInterface;
        List<CarModelInterface> carList = raceService.getCars();
        // stream을 이용하여 양식에 맞게 출력
        carList.stream()
            .forEach(car -> System.out.println(car.getName() + " : " + getProgressBar(car.getProgress())));
        System.out.println();
    }

    // 과정을 담당하는 메서드
    @Override
    public void printProcess() {
        System.out.println("\n실행 결과");
    }

    // 결과를 출력하는 메서드
    @Override
    public void printResult() {
        // service 인터페이스를 통해 값 참조
        List<CarModelInterface> winners = raceServiceInterface.getWinners();
        // 문자열을 빠르게 붙이기 위해 StringBuilder를 사용
        StringBuilder stringBuilder = new StringBuilder();

        // 우승자들의 정보를 String으로 변환한다.
        IntStream.range(0, winners.size() - 1).forEach(i -> stringBuilder.append(winners.get(i).getName()).append(", "));
        stringBuilder.append(winners.get(winners.size() - 1).getName());

        System.out.println("최종 우승자 : " + stringBuilder);
    }

    // 에러 메시지 출력 메서드들
    @Override
    public void printCarsErrorMessage() {
        System.out.println("[ERROR] 입력한 차의 이름이 올바르지 않습니다. 차의 이름은 5자 이하만 가능합니다.");
    }

    @Override
    public void printRoundsArgumentErrorMessage() {
        System.out.println("[ERROR] 횟수는 100 이하여야 합니다.");
    }

    @Override
    public void printRoundsFormatErrorMessage() {
        System.out.println("[ERROR] 횟수는 수로 입력해야 합니다.");
    }
}
