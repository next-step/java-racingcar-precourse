package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    void 사용자_생성_테스트() {
        Players players = new Players("씽씽이,썡썡이,쓩쓩이");
        Assertions.assertThat(players)
                .isEqualTo(
                        new Players(
                                Arrays.asList(
                                        new Car("씽씽이"),
                                        new Car("썡썡이"),
                                        new Car("쓩쓩이")
                                )
                        )
                );
    }
}