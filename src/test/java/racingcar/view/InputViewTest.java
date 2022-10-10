package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    void 경주자동차_이름입력_후_반환() {
        command("yubi,zozo,son,yeopo");
        assertThat(InputView.readCarsName()).hasSize(4);

        command("yubi,");
        assertThat(InputView.readCarsName()).hasSize(1);
    }

    @Test
    void 시도횟수_입력받아_검증후_반환() {
        String uuid = UUID.randomUUID().toString();
        command(uuid);
        assertThat(InputView.readCount()).isEqualTo(uuid);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}