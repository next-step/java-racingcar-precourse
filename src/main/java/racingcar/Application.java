package racingcar;

import static racingcar.constant.COMMENT.*;

import racingcar.interfaces.RacingInterface;
import racingcar.util.TextOutPut;

public class Application {
    public static void processRun(RacingInterface racingInterface){

        while(racingInterface.isAlive()){
            try{
                System.out.print(racingInterface.flushOutPut());
                racingInterface.processRun();
            }catch (IllegalArgumentException e){
                TextOutPut textOutPut = new TextOutPut(e);
                System.out.print(textOutPut.flush());
            }
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingInterface racingInterface = new RacingInterface();
        processRun(racingInterface);

    }
}
