package racingcar.model;

public class Round {

    private final int round;

    public Round(String round) {
        try {
            this.round = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
