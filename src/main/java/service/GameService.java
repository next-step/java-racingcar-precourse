package service;

import constant.GameExceptions;
import constant.MsgTypes;
import model.Car;
import nextstep.utils.Console;


public class GameService {

    private Car car;
    public GameService( Car car ) {
        this.car = car;
    }

    public void initialize() {
        this.carNameSetting();
        this.carGameCountSetting();

    }

    private void carGameCountSetting() {
        int racingCount = 0;
        try{
            racingCount = validationCount();
        }catch ( Exception e ){
            racingCount = validationCount();
        }
        car.setRacingCount( racingCount );
    }

    private int validationCount() {
        MsgTypes.RACING_SETTING_MSG.getMsg();
        int totalCount = Integer.parseInt( Console.readLine() );
        if( totalCount == 0 || totalCount > 65535 ){
            GameExceptions.throwsExceptionMsg( GameExceptions.EXCEPTION_TO_PLAY_COUNT );
            validationCount();
        }
        return totalCount;
    }

    private void carNameSetting(){
        String carNames = validationName();
        car.setCarNames( carNames );
    }

    private String validationName() {
        String carNames = Console.readLine().replaceAll(" ", "");
        MsgTypes.CAR_NAME_SETTING_MSG.getMsg();
        try{
            for ( String str : carNames.split(",") ) {
                lengthCheckToName( str );
            }    
        }catch ( Exception e ){
            validationName();
        }
        return carNames;
    }

    private void lengthCheckToName(String str) throws Exception {

        if( str.length() < 1 || str.length() > 6 ){
            GameExceptions.throwsException( GameExceptions.EXCEPTION_TO_CAR_NAME );
        }

    }

    public void racingStart() {
        MsgTypes.RACING_START_MSG.getMsg();

    }
}
