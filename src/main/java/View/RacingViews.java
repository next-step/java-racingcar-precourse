package View;

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
}
