package service;

import DTO.Car;
import custom.utils.ValidationUtils;
import exception.RacingException;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.List;

public class RacingSevice {

    private static final int MOVING_MIN_NO = 0;
    private static final int MOVING_MAX_NO = 9;
    private static final int MOVING_FORWARD = 4;
    private static final int MOVING_STOP = 3;

    public void startRacingGame() {

        CarService carService = new CarService();
        List<Car> carsInfo =  carService.initCar();

        int inputNum = this.initRacing();

        carsInfo = this.mvCar(carsInfo,inputNum);
        this.endRacing(carsInfo);
    }

    private int initRacing(){

        int count;

        try{
            count = this.inputCount();
        }catch (RacingException e){
            System.out.println(e.getMessage());
            return this.initRacing();
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return this.initRacing();
        }

       return count;
    };

    private int inputCount() throws RacingException, NumberFormatException{

        System.out.println("시도할 횟수는 몇회인가요?");
        String inputTxt = Console.readLine();
        inputTxt = ValidationUtils.rmAllSpace(inputTxt);
        if("".equals(inputTxt)){
            throw new RacingException(" 입력값이 옳바르지 않습니다. 다시입력해주세요");
        }

        int count = 0;
        try {
            count = Integer.parseInt(inputTxt);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 입력값이 올바르지 않습니다.");
        }

        if (count <= 0) {
            throw new RacingException(" 입력값이 올바르지 않습니다.(1이상 입력해주세요)");
        }

        return count;
    }


    public List<Car> mvCar(List<Car> carsInfo, int forCount){

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
        int randomCount = Randoms.pickNumberInRange(MOVING_MIN_NO, MOVING_MAX_NO);
        if (randomCount > MOVING_MAX_NO) {
            return false;
        }
        return randomCount > MOVING_STOP ? true : false;
    }


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

        System.out.println("최종 우승자는 " + resultCar + " 입니다.");

    }

}
