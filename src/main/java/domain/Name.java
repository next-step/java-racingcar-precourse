package domain;

import java.util.regex.Pattern;

public class Name {

    private String name;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;

    public Name(String name) {
        checkLengthName(name);
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    private void checkLengthName(String name) {

        if (isEmptyText(name)) {
            throw new IllegalArgumentException("빈칸을 읿력할수 없습니다.이름은 1글자 이상입니다.");
        }

        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름은 5글자 이내로 입력하여주세요!");
        }

        if(!isOnlyEnglish(name)){
            throw new IllegalArgumentException("이름은 영어대소문자로 입력해야합니다.");
        }
    }

    private boolean isEmptyText(String inputText) {
        return inputText == null || inputText.equals("") || Pattern.matches("\\s", inputText);
    }

    private boolean isOnlyEnglish(String inputText) {
        return Pattern.matches("^[a-zA-Z]*$", inputText);
    }

}
