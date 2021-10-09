package service;

import DTO.Car;
import custom.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class CarService {

   public List<Car> createCar(String inputText) throws Exception {

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

    private List<String> chageList(String inputText) throws Exception {
        inputText = ValidationUtils.rmAllSpace(inputText);
        List<String> carTxtList = new ArrayList<String>();
        for (String str: inputText.split(",")) {
            if(str.length() > 5){
                throw new Exception("[ERROR] 입력한 차량명이 5글자 이상이 존재합니다. = " + str);
            }
            carTxtList.add(str);
        }
        return carTxtList;
    }


}
