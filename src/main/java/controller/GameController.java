package controller;

import service.GameService;

import java.util.Scanner;

public class GameController {
    private final GameService gameService;
    private final Scanner sc;

    public GameController() {
        this.gameService = new GameService();
        this.sc = new Scanner(System.in);
    }

    public void playGame() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
                String input = sc.nextLine();
                String[] names = input.split(",");
                for (String name : names) {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
                    }
                }
                System.out.println("시도할 회수는 몇 회인가요?");
                int count = Integer.parseInt(sc.nextLine()); // 정수 입력 처리

                if (count < 1) {
                    throw new IllegalArgumentException("[ERROR] 시도 회수는 1회 이상이어야 합니다.");
                }

                gameService.setup(names, count);
                gameService.startRacing();

                System.out.println(gameService.getResults());
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }
    }
}