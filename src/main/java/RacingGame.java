import java.util.*;

public class RacingGame {
    /**
     * 최종 우승자 리스트를 받아서 결과를 출력
     * @param winners 최종 우승자 리스트
     * @return 결과 문자열
     */
    public String printResult(List<RacingCar> winners) {
        String res = "";
        res = winners.get(0).getName();
        for (int i=1;i<winners.size();i++) {
            res += ", " + winners.get(i).getName();
        }
        res += "가 최종 우승했습니다.";
        System.out.println(res);
        return res;
    }

    /**
     * 사용자에게 입력받은 자동차 이름 문자열을 RacingCar 리스트로 반환
     * 5자를 초과하는 이름이 존재할 경우 null을 리턴한다.
     * @param str 입력받은 자동차 이름 문자열 (구분자 ",")
     * @return RacingCar 리스트, 5자 초과하는 이름 있을 경우 null
     */
    public List<RacingCar> splitString(String str){
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
