package service;

import DTO.Car;
import constant.Constant;
import custom.utils.ValidationUtils;
import exception.RacingException;
import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class CarService {


   public List<Car> initCar(){

       List<Car> carsInfo = null;
       try{
           carsInfo = this.inputCar();
       }catch(RacingException e){
           System.out.println(e.getMessage());
           return initCar();
       }

       return carsInfo;
   }

   public List<Car> inputCar() throws RacingException {
       System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분");
       String inputTxt = Console.readLine();
       inputTxt = ValidationUtils.rmAllSpace(inputTxt);
       if("".equals(inputTxt)){
           throw new RacingException(" 입력값이 옳바르지 않습니다. 다시입력해주세요");
       }
       return this.createCar(inputTxt);
   }

   public List<Car> createCar(String inputText) throws RacingException {

        List<String> carTxtList = this.chageList(inputText);
        List<Car> carsInfo = new ArrayList<Car>();
        Car car = null;
        for (String str : carTxtList) {
            car = new Car();
            car.setCarNm(str);
            carsInfo.add(car);
        }
        return carsInfo;
    }

    private List<String> chageList(String inputText) throws RacingException {
        inputText = ValidationUtils.rmAllSpace(inputText);
        List<String> carTxtList = new ArrayList<String>();
        for (String str: inputText.split(",")) {
            if(str.length() > 5){
                throw new RacingException(" 입력한 차량명이 5글자 이상이 존재합니다. = " + str);
            }
            carTxtList.add(str);
        }
        return carTxtList;
    }

}
