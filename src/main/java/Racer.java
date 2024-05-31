import java.util.*;

class Racer {
    String name;//이름
    String far = "";//얼마나 멀리 갔는지

    public Racer(String name) {
        this.name = name;
    }

    //전진할지 안 할지 정하기
    public void Go() {
        Random random = new Random();
        int a = random.nextInt(9);
        if (a >= 4) {
            far += "-";
        }
    }
}
