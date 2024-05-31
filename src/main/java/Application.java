import java.util.*;
public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();//사용자 입력 받는 객체 생성
        Vector<Racer> racers = inputHandler.getRacersFromUser();//자동자 이름 입력받는 메서드 호출

        InputHandler2 inputHandler2 = new InputHandler2();
        int numTries = inputHandler2.getTryCountFromUser();//횟수 입력받는 메서드 호출

        RaceService raceService = new RaceService(racers, numTries);//레이스 실행 객체 생성
        raceService.runRace();//레이스 실행

    }
}
