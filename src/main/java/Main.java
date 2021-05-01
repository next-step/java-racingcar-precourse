import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    public boolean start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구룬)");
        String inputNames = scanner.nextLine();

        List<String> names = Utils.splitInputCarNames(inputNames);
        
    }
}
