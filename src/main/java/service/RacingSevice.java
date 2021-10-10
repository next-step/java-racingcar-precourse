package service;

import DTO.Car;
import custom.utils.ValidationUtils;
import exception.RacingException;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.List;

public class RacingSevice {

    public void startRacingGame() {

        CarService carService = new CarService();
        List<Car> carsInfo =  carService.initCar();

        for (Car car : carsInfo) {
            System.out.println("#####################");
            System.out.println("carNM ::" + car.getCarNm());
            System.out.println("carMoveInfo ::" + car.getCarMvInfo());
        }

        int inputNum = this.initRacing();
        System.out.println("#####################");
        System.out.println(inputNum);
    }

    private int initRacing(){

        int count;
        try{
            count = this.inputCount();
        }catch (RacingException e){
            System.out.println(e.getMessage());
            return this.initRacing();
        }catch (ClassCastException e){
            System.out.println(e.getMessage());
            return this.initRacing();
        }

       return count;
    };

    private int inputCount() throws RacingException, ClassCastException{
        System.out.println("시도할 횟수는 몇회인가요?");
        String inputTxt = Console.readLine();
        inputTxt = ValidationUtils.rmAllSpace(inputTxt);
        if("".equals(inputTxt)){
            throw new RacingException(" 입력값이 옳바르지 않습니다. 다시입력해주세요");
        }

        int count = 0;
        try {
            count = Integer.parseInt(inputTxt);
        } catch (ClassCastException e) {
            throw new ClassCastException("[ERROR] 입력값이 올바르지 않습니다.");
        }

        if (count < 0 || count == 0) {
            throw new RacingException(" 입력값이 올바르지 않습니다.(1이상 입력해주세요)");
        }

        return count;
    }


    public List<Car> mvCar(List<Car> carsInfo, int forCount) throws Exception {

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

}
