import domain.race.controller.RaceController;

import java.util.*;

public class Application {

    public static RaceController raceController = new RaceController();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String carNames = inputCarNames();
        int round = inputRound();
        raceController.startRace(carNames,round);
    }

    // 자동차 이름을 입력받는 함수
    public static String inputCarNames(){
        String carNames;
        do{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = sc.nextLine();

        }while(!raceController.canUseCarNames(carNames));

        return carNames;
    }

    // 라운드를 입력받는 함수
    public static int inputRound(){
        String round;
        do{
            System.out.println("시도할 회수는 몇회인가요?");
            round = sc.nextLine();
        }while(!raceController.canUseRound(round));

        System.out.println();
        return Integer.parseInt(round);
    }
}
