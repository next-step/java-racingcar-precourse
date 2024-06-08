import java.util.Scanner;

public class Input {
    public String inputPlayer() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int inputMatch() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void createCarArray(String str, Car[] cars) {
        String[] names = str.split(",");
        int n = names.length;
        for (int i=0; i<n; i++) {
            cars[i] = new Car(names[i], 0);
        }
    }

    public int numOfPlayers(String str) {
        String[] names = str.split(",");
        return names.length;
    }

    public long countComma(String str) {
        return str.chars().filter(ch -> ch == ',').count();
    }
}
