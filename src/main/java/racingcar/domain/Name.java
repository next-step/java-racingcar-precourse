package racingcar.domain;

public class Name {
    private String text;

    public Name(String text) {
        validateLength(text);
        this.text = text;
    }

    private void validateLength(String text) {
        if (text.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }


    public String getText() {
        return text;
    }
}
