package racingcar.domain.count;

public class Count {
    private int round;

    public Count(String number) {
        CountValidation.validation(number);
        this.round = stringToInt(number);
    }

    public int getRound() {
        return this.round;
    }

    private int stringToInt(String number) {
        return Integer.parseInt(number);
    }
}
