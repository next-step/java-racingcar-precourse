package Service;

public class TryCountService {

    // 시도횟수 검증
    // int 자료형 최대 크기를 넘지 않는다.
    public int isNumber(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalStateException();
        }

    }
}
