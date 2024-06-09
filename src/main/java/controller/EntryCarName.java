package controller;

import java.util.*;

public class EntryCarName {
    public static Vector<String> getCarName() {
        Vector<String> carName;
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                carName = input(s);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return carName;
    }

    public static Vector<String> input(String s) throws IllegalArgumentException {//사용자에게 자동차의 이름을 입력받는 기능
        Vector<String> carName = new Vector<>();//입력되는 자동차의 이름을 받을 벡터
        if (s.isEmpty()) throw new IllegalArgumentException("[ERROR] : 자동차 이름을 입력하지 않았습니다. 다시 입력해주세요");

        String[] st = s.split(",", -1);
        for(String name : st ){
            if (name.length() > 5 || name.isEmpty())
                throw new IllegalArgumentException("[ERROR] : 자동차 이름의 길이는5이하여야 합니다");
            carName.add(name);
        }
        return carName;
    }
}
