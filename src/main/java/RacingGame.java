import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RacingGame {
    /**
     * 사용자에게 입력받은 자동차 이름 문자열을 RacingCar 리스트로 반환
     * 5자를 초과하는 이름이 존재할 경우 null을 리턴한다.
     * @param str 입력받은 자동차 이름 문자열 (구분자 ",")
     * @return RacingCar 리스트, 5자 초과하는 이름 있을 경우 null
     */
    List<RacingCar> splitString(String str){
        String[] name_array = str.split(",");
        int len = name_array.length;
        List<RacingCar> res = new ArrayList<>();


        if(!checkLengthOfNames(name_array)){
            return null;
        }

        for(int i=0;i<len;i++){
            res.add(new RacingCar(name_array[i]));
        }
        return res;
    }

    /**
     * 각 이름이 5자 이하인지를 확인
     * @param names 이름 배열
     * @return 모두 5자 이하일 경우 true
     */
    public boolean checkLengthOfNames(String[] names) {
        boolean flag = true;
        for(String name : names){
            flag = flag&& (name.length()<=5);
        }
        return flag;
    }
}
