package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("5글자 초과인 이름을 하였을 때 ")
    void inputNameFiveLenghtExceedTest() {
        assertThatThrownBy(() -> {
            new Name("abcde1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자 이내로 입력하여주세요!");
    }

    @Test
    @DisplayName("공백문자를 하였을 때")
    void inputEmptyTest() {
        assertThatThrownBy(() -> {
            new Name(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸을 읿력할수 없습니다.이름은 1글자 이상입니다.");
    }

    @Test
    @DisplayName("영문 대소문자로만 이루어져있는지 검사")
    void inputTextOnlyEnglishTest() {
        assertThatThrownBy(() -> {
            new Name("abc12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 영어대소문자로 입력해야합니다.");
    }

    @Test
    @DisplayName("정상적 테스트")
    void inputTextSuccessTest() {
        Name name = new Name("crong");
        assertThat(name.name()).isEqualTo("crong");
    }


}
