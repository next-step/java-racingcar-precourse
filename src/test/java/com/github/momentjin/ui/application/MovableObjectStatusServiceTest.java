package com.github.momentjin.ui.application;

import com.github.momentjin.core.model.MovableObject;
import com.github.momentjin.mock.MockLocation;
import com.github.momentjin.mock.MockMovableObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MovableObjectStatusServiceTest {

    MovableObjectStatusService service = new MovableObjectStatusService();

    @DisplayName("MovableObject의 상태 출력 테스트")
    @Test
    void print() {

        // given
        List<MovableObject> list = Arrays.asList(
                new MockMovableObject(() -> "이름1", new MockLocation(1)),
                new MockMovableObject(() -> "이름2", new MockLocation(2)),
                new MockMovableObject(() -> "이름3", new MockLocation(4))
        );

        // when
        String status = service.createText(list);

        // then
        assertThat(status).isEqualTo("" +
                "이름1 : -\n" +
                "이름2 : --\n" +
                "이름3 : ----"
        );
    }
}