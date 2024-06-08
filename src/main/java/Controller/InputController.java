package Controller;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputController {

    Scanner sc;

    public InputController() {
        this.sc = new Scanner(System.in);
    }
    public Set<String> inputCarName() {

        while (true) {
            try {
                return readSc();

            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
    }
    public int inputRaceCount() {

    }
    private Set<String> readSc(){

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
    private void nameLengthCheck(String s){
        if(s.length()>5){
            throw new IllegalArgumentException("[ERROR] : 자동차 이름은 5자 이하입니다.");
        }
    }

    private void nameDuplicateCheck(Set<String> names,String s){
        for(String carName : names){
            if(carName.equals(s)){
                throw new IllegalArgumentException("[ERROR] : 자동차 이름이 중복됩니다.");
            }
        }
    }


}
