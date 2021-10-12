package racinggame;

import nextstep.utils.Console;

public class RacingGame {

    public void start() {

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            RacingCars racingCars = getRacingCarList();
            System.out.println("시도할 회수는 몇회인가요?");
            int raceCnt = 0;
            while (raceCnt <= 0) {
                raceCnt = getRaceCnt();
            }
            for (int i = 0; i < raceCnt; i++) {
                racingCars.racing();
                racingCars.printProgress();
                System.out.println();
            }
            System.out.println("최종 우승자는 " + racingCars.getWinningCarName() + " 입니다.");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private int getRaceCnt() {
        int raceCnt = 0;
        try {
            raceCnt = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자형식이 아닙니다.");
        }
        if (raceCnt <= 0) {
            throw new NumberFormatException("[ERROR] 0보다 큰 숫자여야합니다.");
        }
        return raceCnt;
    }

    private RacingCars getRacingCarList() {
        RacingCars racingCars = null;
        while (racingCars == null) {
            racingCars = new RacingCars(Console.readLine());
        }
        return racingCars;
    }
}
