package Controller;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputController {

    Scanner sc;

    public InputController() {
        this.sc = new Scanner(System.in);
    }
    public Set<String> inputCarName() throws IllegalArgumentException {

        Set<String> carNames = new HashSet<>();

        System.out.println("경주할 자동차 이름을 입력하세요."
            + "(이름은 쉼표(,) 기준으로 구분");

        while (sc.hasNext(",")) {
            String s = sc.next(",");
            nameLengthCheck(s);
            nameDuplicateCheck(carNames,s);
            carNames.add(s);
        }

        return carNames;
    }
    public int inputRaceCount() throws IllegalArgumentException {

    }

    private void nameLengthCheck(String s){
        if(s.length()>5){
            throw new IllegalArgumentException("[ERROR] : 자동차 이름은 5자 이하입니다.");
        }
    }

    private void nameDuplicateCheck(Set<String> names,String s){

    }


}
