package service;

import DTO.Car;
import custom.utils.ValidationUtils;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.List;

public class RacingSevice {

    public void endRacing(List<Car> carsInfo) {

        int maxMv = 0;
        String resultCar = "";

        for (Car car : carsInfo) {
            if (maxMv < car.getCarMvInfo()) {
                maxMv = car.getCarMvInfo();
            }
        }

        for (Car car : carsInfo) {
            if (maxMv == car.getCarMvInfo()) {
                resultCar += resultCar.length() != 0 ? ',' + car.getCarNm() : car.getCarNm();
            }
        }

        System.out.println("최종우숭자는 " + resultCar + " 입니다.");

    }

    public List<Car> mvCar(List<Car> carsInfo, String countTxt) throws Exception {

        int forCount = this.getCount(countTxt);
        String resultMvText = "";
        System.out.println("[SYSTEM] 실행결과");
        for (int i = 0; i < forCount; i++) {
            for (Car car : carsInfo) {
                if (this.isMove()) {
                    car.setCarMvInfo(car.getCarMvInfo() + 1);
                }
                resultMvText = "";
                for (int j = 0; j < car.getCarMvInfo(); j++) {
                    resultMvText += '-';
                }
                System.out.println(car.getCarNm() + " : " + resultMvText);
            }
            System.out.println("========================");
        }
        return carsInfo;
    }

    public boolean isMove() {
        int randomCount = Randoms.pickNumberInRange(0, 9);
        if (randomCount > 9) {
            return false;
        }
        return randomCount > 3 ? true : false;
    }

    @Deprecated
    public int isMove(String countStr) throws Exception {
        int count = this.getCount(countStr);

        int mvCount = 0;
        int randomCount;
        for (int i = 0; i < count; i++) {
            randomCount = Randoms.pickNumberInRange(0, 9);
            if (randomCount > 3) {
                mvCount++;
            }
        }
        return mvCount;
    }

    private int getCount(String countStr) throws Exception {
        countStr = ValidationUtils.rmAllSpace(countStr);
        int count = 0;
        try {
            count = Integer.parseInt(countStr);
        } catch (ClassCastException e) {
            throw new ClassCastException("[ERROR] 입력값이 올바르지 않습니다.");
        }

        if (count < 0 || count == 0) {
            throw new Exception("[ERROR] 입력값이 올바르지 않습니다.(1이상 입력해주세요)");
        }

        return count;
    }

    public void startRacingGame() {
        CarService carService = new CarService();
        carService.inputCar();
    }


}
