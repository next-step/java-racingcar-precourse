package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO : Input Error 발생 시 반복
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        RacingCars racingCars = new RacingCars(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");
        racingCars.play(Console.readLine());
    }
}
