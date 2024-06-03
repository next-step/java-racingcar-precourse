package racingcar.model;

import racingcar.view.InputView;

public class CarName {
    private String names_string;
    public String[] names_arr;

    public CarName(String namesString) {
        this.names_string = namesString;
        this.names_arr =  splitByDelimiter(names_string, ",");
        nameValidate();
    }
    public void nameValidate(){
        validateNameLength();
    }

    public void validateNameLength(){
        for (String name : names_arr) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1~5 글자만 가능합니다.");
            }
        }
    }
    public static String[] splitByDelimiter(String str, String delimiter) {
        return str.split(delimiter);
    }
}
