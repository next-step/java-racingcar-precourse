import java.util.Scanner;

public class GetNumberOfRounds {
    public static int getNumberOfRounds(Scanner scanner) {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇 회인가요?");
                int numberOfRounds = Integer.parseInt(scanner.nextLine());
                CheckRounds.checkRounds(numberOfRounds);
                return numberOfRounds;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
