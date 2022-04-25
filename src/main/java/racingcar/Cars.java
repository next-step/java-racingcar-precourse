package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class Cars {
    public static ArrayList<Car> carList = new ArrayList<>();

    public static ArrayList<Car> getCarList() {
        return carList;
    }

    void setAttendCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarsName();
    }

    void inputCarsName(){
        String inputCarsName = Console.readLine();
        String[] carsNameList = inputCarsName.split(",");
        try {
            setCarsName(carsNameList);
        } catch (IllegalArgumentException e){
            System.out.println(e);
            inputCarsName();
        }
    }

    private void setCarsName(String[] carsNameList) {
        for(int idx = 0; idx < carsNameList.length; idx++){
            Cars.addCar(new Car(carsNameList[idx].trim()));
        }
    }

    private static void addCar(Car car) {
        carList.add(car);
    }
}
