package service;

import constant.GameExceptions;
import constant.MsgTypes;
import model.Car;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.List;
import java.util.Map;


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
            carGameCountSetting();
        }
        car.setRacingCount( racingCount );
    }

    private int validationCount() {
        MsgTypes.RACING_SETTING_MSG.getMsg();
        int totalCount = 0;
        try{
            totalCount = Integer.parseInt( Console.readLine() );
            validationCountLength(totalCount);
        }catch ( Exception e ){
            GameExceptions.throwsExceptionMsg( GameExceptions.EXCEPTION_TO_PLAY_COUNT );
            validationCount();
        }
        return totalCount;
    }

    private void validationCountLength(int totalCount) throws Exception {
        if( totalCount == 0 || totalCount > 65535 ){
            GameExceptions.throwsException( GameExceptions.EXCEPTION_TO_PLAY_COUNT );
            validationCount();
        }
    }

    private void carNameSetting(){
        String carNames = validationName();
        System.out.println( carNames );
        car.setCarNames( carNames );
    }

    private String validationName() {
        MsgTypes.CAR_NAME_SETTING_MSG.getMsg();
        String carNames = Console.readLine().replaceAll(" ", "");
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

        if( str.length() < 1 || str.length() > 5 ){
            GameExceptions.throwsException( GameExceptions.EXCEPTION_TO_CAR_NAME );
        }

    }

    public void racingStart() {
        MsgTypes.RACING_START_MSG.getMsg();
        runningStart();
    }

    private void runningStart() {
        List<String> carList = car.getList();
        Map<String, Integer> carInfo = car.getCarInfo();
        for( int i = 0; i < car.getRacingCount(); i++ ){
            setDistance( carInfo, carList );
        }
        car.getResult();
    }

    private void setDistance(Map<String, Integer> carInfo, List<String> carList) {
        for( String carName : carList ){
            carInfo.put( carName, carInfo.get( carName ) + Randoms.pickNumberInRange(1,2) );
        }
        car.getTentativeResults();
    }
}
