package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Racer {

    private String name;
    private int labs;

    public Racer(String name, int labs) {
        validateLength(name);
        this.name = name;
        this.labs = labs;
    }

    private void validateLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 1~5자 이하여야 합니다.");
        }
    }

    public void setLabs() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            labs++;
        }
    }

    public int getLabs() {
        return labs;
    }

    public void printLabs() {

        StringBuilder result = new StringBuilder(this.getName() + " : ");
        for (int i = 0; i < labs; i++) {
            result.append("-");
        }
        System.out.println(result);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Racer{" +
                "name='" + name + '\'' +
                '}';
    }
}
