import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InputCarName icn = new InputCarName();
        HandleGame hg = new HandleGame();
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> carList = new ArrayList<>();


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        icn.splitInput(sc.next());
        carList = icn.getCarList();


        System.out.println("시도할 회수는 몇회인가요?");
        hg.startGame(sc.nextInt(), carList);

        sc.close();
    }
}