import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Set {

    public static List<Car> setCar() {
        List<Car> cars = new ArrayList<>();
        String[] names;
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        names = sc.nextLine().split(",");
        for(int i=0; i<names.length;i++) {
            cars.add(new Car(names[i].trim()));
//            System.out.println("입력 완료.");
        }

        return cars;
    }

    public static int setAttempt(){
        int attempt;
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("시도할 회수는 몇회인가요?");
        attempt = sc.nextInt();
        return attempt;
    }

}
