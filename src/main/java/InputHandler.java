import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class InputHandler {

    public static void CarNameInput(Vector<Car> cars) throws IOException {
        //사용자 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");
        for (int i = 0; i < s.length; i++) {
            cars.add(new Car(s[i].trim(), 0));
        }
    }

    public static int attemptCountInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("시도할 횟수는 몇회인가요?");
        int number = Integer.parseInt(br.readLine());
        return number;
    }

}
