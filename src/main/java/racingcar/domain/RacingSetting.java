package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.MessageMaker;

public class RacingSetting {

    private Cars cars = new Cars();
    private boolean carsSettingAt = false;

    private int round = 0;
    private boolean roundSettingAt = false;

    public  RacingSetting(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        while (!this.carsSettingAt){
            try {
                cars = new Cars(Console.readLine());
                this.carsSettingAt = true;
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                this.carsSettingAt = false;
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        while (!roundSettingAt){
            try{
                settingRoundNum();
                this.roundSettingAt = true;
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                this.roundSettingAt = false;
            }
        }
    }

    public void settingRoundNum(){
        String roundNum = Console.readLine();
        validateRoundNum(roundNum);
        this.round = Integer.parseInt(roundNum);
    }

    public Cars getCars() {
        return cars;
    }

    public int getRound(){
        return round;
    }

    private void validateRoundNum(String roundNum) {
        try{
          Integer.parseInt(roundNum);
        }catch (NumberFormatException ne){
            throw new IllegalArgumentException(MessageMaker.consoleOutErrorMessage("시도할 회수는 숫자로만 입력해야합니다."));
        }
    }
}
