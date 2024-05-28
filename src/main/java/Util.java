import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.w3c.dom.ls.LSOutput;

public class Util {

    Random random = new Random();

    // 자동차명 입력 확인
    public void checkNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 시도횟수 검증
    public void isNumber(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    // 랜덤 넘버 생성
    public int generateRandomNumber() {
        return random.nextInt(10);
    }

}
