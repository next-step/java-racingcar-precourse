import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Make Using Objects
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        // Make racing cars process
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str;
        // Confirm Name Error Case
        while (true) {
            try {
                str = sc.nextLine();
                if (str.charAt(0) == ',')
                    throw new IllegalArgumentException("[ERROR] 입력의 시작이 ',' 일 수 없습니다!");
                else if (str.charAt(str.length() - 1) == ',')
                    throw new IllegalArgumentException("[ERROR] 입력의 끝이 ',' 일 수 없습니다!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        game.makeCars(str);

        // Choose Racing sequence Count process
        System.out.println("시도할 회수는 몇회인가요?");
        int count;
        while (true) {
            try {
                String temp = sc.next();
                count = Integer.parseInt(temp);
                if (count < 0)
                    throw new IllegalArgumentException("[ERROR] 횟수가 음수일 수 없습니다!");
                break;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 정수를 입력해주세요!");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        // Print Result process
        System.out.println("\n실행결과");
        for (int i = 0; i < count; i++) {
            System.out.println(game.racing());
        }

        // Print Game's Winner
        System.out.print("최종 우승자 : ");
        String[] strings = game.chooseWinner();
        for (int i = 0; i < strings.length; i++) {
            if (strings.length - 1 == i) {
                System.out.println(strings[i]);
                break;
            }
            System.out.print(strings[i]);
        }
    }
}
