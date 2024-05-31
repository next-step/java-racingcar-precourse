package Util;

import DTO.Car;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Util {

    Random random = new Random();
    // 랜덤 넘버 생성
    public int generateRandomNumber() {
        return random.nextInt(10);
    }


}
