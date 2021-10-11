package racinggame;

import nextstep.utils.Console;

public class RacingGame {

    private int raceCnt;

    public int getRaceCnt() {
        return raceCnt;
    }

    public void start() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            RacingCars racingCars = new RacingCars(Console.readLine());
            System.out.println("시도할 회수는 몇회인가요?");
            raceCnt = Integer.parseInt(Console.readLine());
            for (int i = 0; i < raceCnt; i++) {
                racingCars.racing();
                racingCars.printProgress();
                System.out.println();
            }
            System.out.println("최종 우승자는 " + racingCars.getWinningCarName());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자형식이 아닙니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
