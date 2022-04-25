package service;

import camp.nextstep.edu.missionutils.Console;
import exception.ExceptionWrapper;
import model.BlackBox;
import model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CarRacingCompetition {

    private List<Car> joinCarList = null;

    private CarRacingCompetition(String strJoinCarList) throws IllegalStateException, IllegalArgumentException{
        this.joinCarList = new ArrayList<Car>();
        setJoinCarList(strJoinCarList);
    }

    public static CarRacingCompetition getCarRacingCompetion(String strJoinCarList)
     throws IllegalStateException, IllegalArgumentException{
        return new CarRacingCompetition(strJoinCarList);
    }

    public List<Car> getWinnerList(){
        List<Car> winnerList = new ArrayList<>();
        for(Car car : joinCarList){
            winnerList = makeWinnerList(winnerList, car);
        }
        return winnerList;
    }

    private List<Car> makeWinnerList(List<Car> winnerList, Car car) {
        if(winnerList.size()==0){
            winnerList.add(car);
        }else if(winnerList.size()!=0){
            Car diffCar = winnerList.get(0);
            int recodeSize = car.readBlackBoxRecordSize();
            winnerList = getDiffWinnerList(winnerList, car, diffCar, recodeSize);
        }
        return winnerList;
    }

    private List<Car> getDiffWinnerList(List<Car> winnerList, Car car, Car diffCar, int recodeSize) {
        int diffRecordSize = diffCar.readBlackBox(0, recodeSize);
        int recordSize = car.readBlackBox(0, recodeSize);
        if(recordSize>=diffRecordSize){
            if(recordSize>diffRecordSize)
                winnerList.clear();
            winnerList.add(car);
        }
        return winnerList;
    }


    public List<Car> startRacing(String strAccelCount){
        int accelCount = convertStrAccelLimitToAccelCount(strAccelCount);
        startRacing(accelCount);
        return getResult();
    }

    private void startRacing(int accelCount) {
        for(Car car : joinCarList){
            car.tryAccel(accelCount);
        }
    }

    private List<Car> getResult(){
        return this.joinCarList;
    }

    private int convertStrAccelLimitToAccelCount(String strAccelCount){
        try{
            int result = Integer.parseInt(strAccelCount);
            if(result>=0){
                return result;
            }
                throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
        }catch (IllegalArgumentException e){
            throw new NumberFormatException("시도 횟수는 숫자여야 한다.");
        }
    }

    private void setJoinCarList(String strJoinCarList) throws IllegalStateException, IllegalArgumentException{
        checkNull(strJoinCarList, "참여하는 자동차의 명단이 null 입니다.");
        checkSpliterOnString(strJoinCarList);
        setJoinCarList(strJoinCarList.split(",", 0));
    }

    private void setJoinCarList(String[] arrJoinCarName) throws IllegalStateException, IllegalArgumentException{
        for(String joinCarName : arrJoinCarName){
            joinCarName = joinCarName.trim();
            checkSpaceOnString(joinCarName);
            checkNameLength(joinCarName);
            addCar(new Car(joinCarName, new BlackBox()));
        }
    }
    private void checkNameLength(String joinCarName) throws IllegalArgumentException{
        if(joinCarName.length()<=5){
            return;
        }
        throw new IllegalArgumentException("참가 자동차의 이름이 6글자 이상입니다.");
    }

    private void addCar(Car car){
        this.joinCarList.add(car);
    }

    private void checkSpaceOnString(String carName) throws IllegalArgumentException{
        if(!carName.equals("")){
            return;
        }
        throw new IllegalArgumentException("참여 자동차명이 공백값 입니다.");
    }

    private void checkNull(String strCarList, String massage) throws NullPointerException{
        if(strCarList!=null){
            return;
        }
        throw new NullPointerException(massage);
    }

    private void checkSpliterOnString(String strCarList) throws IllegalArgumentException{
        if(!strCarList.contains(",,")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR],가 2개 이상 연속적으로 입력되었습니다.");
    }
}
