package service;

import model.Car;
import nextstep.utils.Console;

public class GameService {

    private Car car;

    public GameService( Car car ) {
        this.car = car;
    }

    public void initialize(){
        this.carNameSetting();
    }

    private void carNameSetting(){
        System.out.println( "경주할 자동차 이름을 입력하세요." );
        String carNames = Console.readLine();
        car.setCarNames( carNames );
    }

}
