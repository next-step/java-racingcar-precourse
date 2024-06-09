package Controller;
import java.util.Random;

public class ForwardLogic {
    public boolean forwarding() {
        Random random = new Random();
        double a = random.nextDouble() * 10; // 0부터 10 사이의 무작위 수 생성
        return a >= 4;
    }
}
