package Util;

import java.util.Random;

public class Util {

    Random random = new Random();

    // 랜덤 넘버 생성
    public int generateRandomNumber() {
        return random.nextInt(10);
    }


}
