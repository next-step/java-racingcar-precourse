package view;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Input {
    Scanner sc = new Scanner(System.in);
    private String[] car_name;
    private int num;


    // 자동차 이름 입력 받기
    public String[] inputCars() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        car_name = sc.nextLine().strip().split(",");

        for(String car : car_name){
            if(!validateCarNameLength(car))
                throw new IllegalThreadStateException("[ERROR] 잘못된 자동차 이름입니다. 5자 이하로 띄어쓰기 없이 입력해 주세요");
        }

        if(!validateCarNameUniqueness(car_name))
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름입니다. 다시 입력해 주세요");

        return car_name;
    }

    // 자동차 이름의 길이가 5자 이하인가
    private boolean validateCarNameLength(String car) {
        return car.length() <= 5;
    }

    // 자동차 이름에 중복은 없는가?
    private boolean validateCarNameUniqueness(String[] car_name) {
        Set<String> uniqueCarNames = new HashSet<>(List.of(car_name));
        return car_name.length == uniqueCarNames.size();
    }

    // 시도 횟수 입력 받기
    public int attemptCount() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇회인가요?");
        int num = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리
        if (num <= 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 시도 횟수입니다. 다시 입력해 주세요");
        }
        return num;
    }


}
