import java.util.StringTokenizer;

public class Validator {
    public static void validCheckCarNames(String inputCarNames) throws InvalidCarNameException {
        StringTokenizer stringTokenizer = new StringTokenizer(inputCarNames, ",");
        int tokenSize = stringTokenizer.countTokens();
        if (tokenSize <= 0)
            throw new InvalidCarNameException("입력된 차량 대수가 0대입니다");

        if (tokenSize == 1)
            throw new InvalidCarNameException("입력된 차량 대수가 1대입니다");

        if (tokenSize > 10)
            throw new InvalidCarNameException("자동차 이름은 10개까지 입력 가능합니다");
    }
}
