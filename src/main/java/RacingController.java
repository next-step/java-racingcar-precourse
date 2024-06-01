import java.util.Scanner;

public class RacingController {
    static Scanner scanner = new Scanner(System.in);
    public static void initCar() {
        while(true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            try {
                carVerify(scanner.nextLine().split(","));
                return;
            } catch (IllegalStateException e){
                System.out.println("[ERROR] 경주를 시작하려면 2대 이상의 자동차를 입력해야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 자동차 이름은 5자를 넘길 수 없습니다.");
            }
        }
    }
    public static void carVerify(String[] carList) {
        if(carList.length <= 1)
            throw new IllegalStateException();
        for(int i=0; i<carList.length; i++) {
            if(carList[i].length() > 5)
                throw new IllegalArgumentException();
        }
        createList(carList);
    }
    public static void createList(String[] carList) {
        for(String car: carList)
            Application.racingCar.add(new Car(car));
    }
    public static int tryNum() {
        while(true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                int n = verify(scanner.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] int형 정수만 입력이 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1 ~ 2,147,483,647사이의 정수를 입력하세요.");
            }
        }
    }
    public static int verify(String n) {
        int number = Integer.parseInt(n);
        if(number < 1) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
