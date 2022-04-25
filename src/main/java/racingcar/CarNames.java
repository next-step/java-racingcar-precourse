package racingcar;

public class CarNames {

    private final String CAR_NAME_DELEMETER = ",";

    String carNames;

    public CarNames() {

    }
    public CarNames(String s) {
        isCarNamesNull(s);
        isCarNamesEmpty(s);
        isCarNamesNotInComma(s);

        this.carNames = s;
    }

    public void isCarNamesNull(String s) {

        if (s == null) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름을 입력해야 합니다.");
        }

    }

    public void isCarNamesEmpty(String s) {

        if ("".equals(s.trim())) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름을 입력해야 합니다.");
        }

    }

    public void isCarNamesNotInComma(String s) {

        if (!s.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차는 최소 2대 이상이어야 합니다.");
        }

    }

    public String[] carNameSplit() {
        return carNames.split(CAR_NAME_DELEMETER);
    }
}
