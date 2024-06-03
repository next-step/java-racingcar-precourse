import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import model.GameStatus;
import java.util.Map.Entry;


public class Show {
    private static final Scanner scanner=new Scanner(System.in);

    public static String nameInit() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = scanner.nextLine();
            System.out.println();
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Integer numInit() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            int goals = Integer.parseInt(scanner.nextLine());
            System.out.println();
            return goals;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void currentStatus(GameStatus status) {
        Iterator<Entry<String, Integer>> entries = status.getTryCurrent().entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<String, Integer> entry = entries.next();
            System.out.println(entry.getKey() + " : " +  "-".repeat(entry.getValue()));
        }
    }

    public static void winner(GameStatus status){
        System.out.println("최종 우승자 : " + status.getWinners().toString());
    }

}
