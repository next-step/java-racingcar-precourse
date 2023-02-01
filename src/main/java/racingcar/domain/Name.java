package racingcar.domain;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Name {
    private String name;

    public Name(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 빈값일 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5를 초과할 수 없습니다.");
        }

        this.name = name;
    }
}
