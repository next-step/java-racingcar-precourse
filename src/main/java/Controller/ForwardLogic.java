package Controller;
import java.util.Random;

public class ForwardLogic {
    public boolean forwarding() {
        Random random = new Random();
        int randomNumber = random.nextInt(10); // 0부터 9 사이의 무작위 정수 생성
        return randomNumber >= 4;
    }
}
