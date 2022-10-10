package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrackDtoTest {

    @Test
    void DTO_Track_변환_문자열_예외() {
        assertThatThrownBy(() -> new TrackDto("가").toDomain())
                .hasMessage("레이싱 트랙 값은 숫자만 가능합니다.");
    }

    @Test
    void DTO_Track_변환_숫자_예외() {
        assertThatThrownBy(() -> new TrackDto("0").toDomain())
                .hasMessage("레이싱 트랙 값이 유효하지 않습니다.");
    }
}
