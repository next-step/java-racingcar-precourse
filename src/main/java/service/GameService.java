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
    private boolean countValidResult;
    private boolean carNameValidResult;
    private int totalCount;

    public GameService( Car car ) {
        this.car = car;
        this.countValidResult = false;
        this.carNameValidResult = false;
        this.totalCount = 0;

    }

    public void initialize() {
        this.carNameSetting();
        this.carGameCountSetting();

    }

    private void carGameCountSetting() {
        while( !countValidResult ){
            countValidResult = validationCount();
        }
    }

    private boolean validationCount() {
        MsgTypes.RACING_SETTING_MSG.getMsg();
        try{
            totalCount = Integer.parseInt( Console.readLine() );
            validationCountLength(totalCount);
        }catch ( Exception e ){
            GameExceptions.throwsExceptionMsg( GameExceptions.EXCEPTION_TO_PLAY_COUNT );
            return false;
        }
        return true;
    }

    private void validationCountLength(int totalCount) throws Exception {
        if( totalCount == 0 || totalCount > 65535 ){
           throw GameExceptions.throwsException( GameExceptions.EXCEPTION_TO_PLAY_COUNT );
        }
        car.setRacingCount(totalCount);
    }

    private void carNameSetting(){
        MsgTypes.CAR_NAME_SETTING_MSG.getMsg();
        String carNames = Console.readLine();
        while( !carNameValidResult ){
            carNameValidResult = validationName( carNames );
        }
    }

    private boolean validationName( String carNames ) {

        for ( String str : carNames.replaceAll(" ", "").split(",") ) {
            return lengthCheckToName(str);
        }
        car.setCarNames( carNames );
        return true;
    }

    private boolean lengthCheckToName(String str) {

        if( str.length() < 1 || str.length() > 5 ){
            GameExceptions.throwsExceptionMsg( GameExceptions.EXCEPTION_TO_CAR_NAME );
            return false;
        }
        return true;
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
