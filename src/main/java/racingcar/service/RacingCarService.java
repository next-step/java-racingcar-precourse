package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.PlayResult;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarService {

    private static Cars cars;
    private static int maxProgress;
    private static List<String> winnerList;

    public RacingCarService() {
        maxProgress = 0;
        winnerList = new ArrayList<>();
    }

    public void inputRacingCar(){
        List<Car> list = new ArrayList<>();
        String inputCars = readLine();
        if(!checkCarNameComma(inputCars)) throw new IllegalArgumentException("자동차 2대 이상 입력해주세요.");
        String[] split = inputCars.split(",");
        for(int i = 0; i < split.length; i++) list.add(new Car(isNameCheck(split[i])));
        cars = new Cars(list);
    }

    public void racingCarsPlay() {
        int tryNum = Integer.parseInt(readLine());
        for(int i = 0; i < tryNum; i++) cars.play();
        compareBestCar();
    }

    public void compareBestCar() {
        maxProgress = cars.getMaxProcess();
        List<String> list = cars.setWinnerCars(maxProgress);
        for(String name : list) getWinnerList(name);
        PlayResult.getResultPrint(winnerList);
    }

    public void getWinnerList(String name) {
        if(isNullCheck(name)) return;
        winnerList.add(name);
    }

    public boolean isNullCheck(String str) {
        if(str == null || str == "") return true;
        return false;
    }

    public String isNameCheck(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        return name;
    }

    public boolean checkCarNameComma(String nameStr) {
        return nameStr.contains(",");
    }
}
