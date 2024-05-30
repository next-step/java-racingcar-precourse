package View;

import Model.RacingCarsVO;
import java.util.Scanner;

public class RacingViews {

    private Scanner sc;

    public RacingViews() {
        this.sc = new Scanner(System.in);
    }

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine();
    }

    public int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return sc.nextInt();
    }

    public void displayResult(String result){
        System.out.println(result);
    }

    public void displayWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
