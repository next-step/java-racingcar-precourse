package Util;

public class RandomNumber {
    // static 메소드만 있으므로 private로 정의
    private RandomNumber() {
    }

    // 랜덤한 0~9사이의 정수 생성
    public static int makeRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
