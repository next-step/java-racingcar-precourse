import java.util.List;
import java.util.Scanner;

public class Game {

    public List<String> getCarName() {
        List<String> carNames;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = List.of(sc.nextLine().split(","));
            if (CheckInput.checkCarNames(carNames)) {
                sc.close();
                break;
            }
        }
        return carNames;
    }

    public int getTryNum() {
        int tryNum;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                tryNum = sc.nextInt();
                break;
            } catch (IllegalArgumentException e) {
                CheckInput.isWrongValue();
            }
        }
        return tryNum;
    }




}
