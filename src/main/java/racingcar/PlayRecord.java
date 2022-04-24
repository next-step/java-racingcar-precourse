package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class PlayRecord {

    public static final String number_exception
            = "[ERROR] Try count should be number(int)";
    public static final String plus_exception
            = "[ERROR] Try count should be plus number";
    private Integer round = 0;

    private void validInteger(String i) {
        try {
            Integer.parseInt(i);
        } catch (Exception e) {
            System.out.println(number_exception);
            throw new IllegalArgumentException();
        }
    } // validInteger method


    private void validPlus(String i) {
        if (Integer.parseInt(i) <= 0) {
            System.out.println(plus_exception);
            throw new IllegalArgumentException();
        }
    } // validPlus method

    private void validInput(String i) {
        validInteger(i);
        validPlus(i);
    }

    public void getInput() {
        try {
            String input = Console.readLine();
            validInput(input);
            round = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            getInput();
        }
    }

    public boolean isSame(PlayRecord record) {
        return this.equals(record);
    }

    public void increase() {
        round += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PlayRecord record = (PlayRecord)o;
        return Objects.equals(round, record.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }


}
