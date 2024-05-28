import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Make Using Objects
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        // Make racing cars process
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = sc.next();
        game.makeCars(str);

        // Choose Racing sequence Count process
        System.out.println("시도할 회수는 몇회인가요?");
        int count = sc.nextInt();

        // Print Result process
        System.out.println("\n실행결과");
        for(int i = 0; i < count; i++){
            System.out.println(game.racing());
        }

        // Print Game's Winner
        System.out.print("최종 우승자 : ");
        String[] strings = game.chooseWinner();
        for(int i = 0; i < strings.length-1; i++)
            System.out.print(strings[i] + ",");
        System.out.println(strings[strings.length-1]);
    }
}
