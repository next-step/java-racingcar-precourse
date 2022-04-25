package racingcar.service;

import racingcar.model.Racing;
import racingcar.model.primitive.CarNameList;
import racingcar.util.Utils;

public class RacingService implements Service {

    Racing racingCars;
    CarNameList carsNameList;

    public RacingService() {
    }

    @Override
    public void start() {

        while (RacingGame()) {
            RacingGame();
        }

    }

    private Boolean RacingGame() {

        try {
            carsNameList = new CarNameList(Utils.getInput("경주할자동차이름(이름은쉼표(,)기준으로구분)"));
            racingCars = new Racing(carsNameList.getList());

            int lap = getLap();

            for (int i = 0; i < lap; i++) {
                racingCars.moveCheck();
                System.out.println();
            }
            racingCars.getResult();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return true;
        }
        return false;
    }

    public int getLap(){

        try{
            String lapStr = Utils.getInput("시도할 회수는 몇회인가요?");
            return Utils.stringToInt(lapStr);
        } catch (Exception e){
            throw e;
        }


    }
}
