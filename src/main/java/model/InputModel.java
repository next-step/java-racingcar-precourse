package model;

import camp.nextstep.edu.missionutils.Console;
import vo.CarVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputModel {
    private RacingCarName racingCarName;
    private RaceCicle raceCicle;
    public static class RaceCicle {
        private int raceCicle;
        public RaceCicle(String input) {
            if(!input.matches("[1-9]*")) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
            }
            raceCicle = Integer.parseInt(input);
        }
    }
    public static class RacingCarName {
        private String racingCarName;
        public RacingCarName(String racingCarName) {
            if(racingCarName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 차의 이름은 5글자를 초과할 수 없습니다.");
            }
            this.racingCarName = racingCarName;
        }
    }

    public static CarVo getInputCar(CarVo carVo) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        carVo = seperateCar(input, carVo);
        return carVo;
    }

    private static CarVo seperateCar(String input, CarVo carVo) {
        String[] array = input.split(",");
        List<String> carInfo = new ArrayList<String>();
        List<Integer> carScore = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++) {
            carInfo.add(String.valueOf(new RacingCarName(array[i])));
            carScore.add(0);
        }
        carVo.setCarName(Arrays.asList(array));
        carVo.setCarScore(carScore);
        return carVo;
    }

    public static int getInputRace() {
        System.out.println("시도할 횟수는 몇회인가요?");
        RaceCicle raceCicle = new RaceCicle(Console.readLine());
        return raceCicle.raceCicle;
    }

}
