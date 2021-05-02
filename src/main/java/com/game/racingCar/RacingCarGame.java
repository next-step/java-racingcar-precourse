package com.game.racingCar;

import com.game.global.Game;
import com.game.global.utils.IntegerUtils;

import java.util.*;

import static java.lang.String.format;

public class RacingCarGame implements Game {

    protected static Scanner scanner;

    protected Integer tryCount;
    protected Integer playCount;
    protected RacingControlTower racingControlTower;


    @Override
    public void prepare() {
        scanner = new Scanner(System.in);
        final String carList = inputCarList();
        this.tryCount = inputTryCount();
        this.playCount = 0;
        this.racingControlTower = new RacingControlTower(carList);
    }

    @Override
    public void play() {
        final Map<String, RacingCar> statusMap = racingControlTower.getStatusMap();
        final Iterator<String> statusIterator = statusMap.keySet().iterator();
        while (statusIterator.hasNext()) {
            final String carName = statusIterator.next();
            final RacingCar racingCar = statusMap.get(carName);
            racingCar.goForward(IntegerUtils.getRandomSingleNumber());
        }
        System.out.println();
        if (tryCount > ++playCount) {
            this.play();
        }
    }

    @Override
    public void result() {
        final List<String> winnerList = racingControlTower.getWinnerList();
        System.out.println(format("%s가 최종 우승했습니다.", String.join(",", winnerList)));
    }


    private static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private static String inputCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

}
