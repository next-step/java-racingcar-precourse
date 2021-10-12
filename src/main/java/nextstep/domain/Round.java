package nextstep.domain;

public class Round {

    private static final String NON_NUMBER_MESSAGE = "[ERROR] 숫자가 아닌 문자는 입력받을 수 없습니다.";

    private final int round;

    public Round(String round) {
        checkRound(round);
        this.round = Integer.parseInt(round);
    }

    public Round(int round) {
        this.round = round;
    }

    private void checkRound(String round) {
        for (char ch : round.toCharArray()) {
            checkDigit(ch);
        }
    }

    private void checkDigit(char ch) {
        if (!Character.isDigit(ch)) {
            System.out.println(NON_NUMBER_MESSAGE);
            throw new IllegalArgumentException(NON_NUMBER_MESSAGE);
        }
    }

    public int getRound() {
        return round;
    }
}
