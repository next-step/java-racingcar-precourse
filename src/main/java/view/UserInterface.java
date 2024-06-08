package view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public int explain() {

        System.out.println("🚗 자동차 경주 게임에 오신걸 환영합니다! 🪄");
        System.out.println("경기 설명 : n번의 라운드 동안 자동차는 전진을 할 수도 있고, 이동하지 않을 수도 있습니다! 과연 어떤 자동차가 우승을 하게 될까요??");

        return 1;
    }

    public String enterCarName() {

        // 사용자에게 자동차 이름 입력받기
        System.out.println("먼저 당신은 준비시킬 자동차를 입력해야합니다! 자동차는 공백을 입력해서는 안되고, ','로 구분해서 입력할 수 있습니다.");
        System.out.println("ex _ 붕붕이,씽씽이");
        System.out.print("입력: ");
        String carNamesInput = scanner.nextLine();

        return carNamesInput;

    }

    public int getCarName(LinkedHashMap<String, Integer> carMap) {
        StringBuilder carListBuilder = new StringBuilder();
        int order = 1;

        carListBuilder.append(String.format("당신이 준비시킨 %d개의 자동차입니다!\n", carMap.size()));

        for (String carName : carMap.keySet()) {
            carListBuilder.append(String.format("%d. %s\n", order++, carName));
        }

        System.out.println(carListBuilder.toString());
        System.out.println();
        return 0;
    }

    public String enterNumberOfRounds() {


        // 사용자에게 자동차 이름 입력받기
        System.out.println("좋아요! 이제 라운드를 몇번 진행할건가요?");
        System.out.println("입력값은 1~12 사이의 숫자입니다. 문자를 포함해서는 안됩니다~! ;) ");
        System.out.print("입력: ");
        String roundInput = scanner.nextLine();

        System.out.println();
        return roundInput;
    }

    public int getNumberOfRounds(int roundNum) {
        System.out.println("좋아요! 총 " + roundNum + "번을 진행할게요!");
        System.out.println();
        return 0;
    }

    public int printRoundResults(int currentNumberOfRounds, LinkedHashMap<String, Integer> carMap) {
        System.out.println(currentNumberOfRounds + "번째 결과는?!?! ");


        int order = 1;
        for (String carName : carMap.keySet()) {
            // 자동차 이름과 거리(대시('-')로 표현) 출력
            System.out.println(order + ". " + carName + ": " + "-".repeat(carMap.get(carName)));
            order++;
        }

        System.out.println();
        return 0;
    }

    public int printWinners(List<String> winningCars) {

        String result = String.join(" ", winningCars);

        // 결과 메시지를 출력합니다.
        System.out.println("이번 경기의 우승 🚗 는 : " + result + "입니다~!!!!!");
        System.out.println("축하해요~!");

        return 0;
    }

}



