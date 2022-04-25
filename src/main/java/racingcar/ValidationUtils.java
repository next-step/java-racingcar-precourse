package racingcar;

import racingcar.domain.CarInfoVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ValidationUtils extends IllegalArgumentException{
    public boolean validName(String userInput) {
        CarInfoVo carInfoVo = new CarInfoVo();
        List<String> nameList = new ArrayList<>();

        //입력받은 이름 리스트 분리
        splitNameList(userInput, carInfoVo);
        System.out.println("userInput = "+userInput);
        try{
            //이름 입력 값 체크 (아무것도 입력되지 않았거나 쉼표만 입력된 경우)
            validNameValue(carInfoVo);

            //이름 길이 체크 (이름값이 입력되지 않았거나 5자리 초과한 경우 에러)
            validNameLength(carInfoVo);

            //중복값이 입력된 경우 체크
            validNameDuplicate(carInfoVo);
        } catch(IllegalArgumentException e) {
//            System.out.println("[ERROR] " + e.getClass().getName());
            System.out.println(e.toString());
            //throw new IllegalArgumentException();   //에러 대신 다시 입력받도록 해야함
            return false;
        }
        return true;
    }

    private boolean splitNameList(String name, CarInfoVo carInfoVo) {
        return Collections.addAll(carInfoVo.getNameList(), name.split(","));
    }

    private void validNameValue(CarInfoVo carInfoVo){
        if(carInfoVo.getNameList().size() == 0){
            throw new IllegalArgumentException("[ERROR] 이름을 정확히 입력해주세요.");
        }
    }

    private void validNameLength(CarInfoVo carInfoVo) {
        if (carInfoVo.getNameList().stream().anyMatch(name -> name.length() == 0))
            throw new IllegalArgumentException("[ERROR] 입력된 이름이 없습니다.");
        else if (carInfoVo.getNameList().stream().anyMatch(name ->  name.length() > 5))
            throw new IllegalArgumentException("[ERROR] 이름이 5글자를 초과합니다.");
    }


    private void validNameDuplicate(CarInfoVo carInfoVo) {
        HashSet<String> hs = new HashSet<>();
        carInfoVo.getNameList().stream().filter(
                name -> !hs.add(name.toUpperCase())
                )
                .forEach(name -> {
                    throw new IllegalArgumentException("[ERROR] 중복된 이름이 입력되었습니다.");
                });
    }


    public static boolean validRepeat(String repeatCnt) throws IllegalArgumentException {
        try {
            return (!repeatCnt.isEmpty() && !(Integer.parseInt(repeatCnt) < 1));
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] " + "반복횟수를 잘못 입력하였습니다.");
            return false;
        }
    }
}
