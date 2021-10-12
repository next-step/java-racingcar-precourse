package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        String inputNames = Console.readLine();
        String[] names = inputNames.split(",");
        for (String name : names) {
            if (name.length() >= 5) {
                System.out.println("[ERROR] 이름 길이가 너무 길어요.");
            }
        }
        Console.readLine();
        String[] strs = {
            "pobi : -", "woni : ", "최종 우승자는 pobi 입니다."
        };
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
