package service;

import DTO.Car;
import custom.utils.ValidationUtils;
import nextstep.utils.Randoms;

import java.util.List;

public class RacingSevice {

    public void isMove(String countStr) throws Exception {
      int count = this.getCount(countStr);

      int mvCount = 0;
      int randomCount;
      for(int i=0; i<count; i++){
        randomCount = Randoms.pickNumberInRange(0,9);
        if(randomCount > 3){ mvCount++;}
      }
    }

    private int getCount(String countStr) throws Exception {
        countStr = ValidationUtils.rmAllSpace(countStr);
        int count = 0;
        try{
            count = Integer.parseInt(countStr);
        }catch (ClassCastException e){
            throw new ClassCastException("[ERROR] 입력값이 올바르지 않습니다.");
        }

        if(count < 0 || count == 0){
            throw new Exception("[ERROR] 입력값이 올바르지 않습니다.(1이상 입력해주세요)");
        }

        return count;
    }

    public void mvCar(List<Car> carsInfo, String mvText) {

    }


}
