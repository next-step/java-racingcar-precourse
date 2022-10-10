package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

class BasicBillBoardTest {

    @Captor
    private ArgumentCaptor<String> captor;

    @Mock
    private UserOutput userOutput;

    @InjectMocks
    private BasicBillBoard billBoard;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("최종 우승자를 출력할 때 header와 우승자가 붙여져 출력되어야 함")
    void test1() {
        WinnerRacingCarViews views = WinnerRacingCarViews.of(
                Collections.singletonList(
                        RaceCarView.of(UserString.of("car1"), NaturalNumber.of(10))
                )
        );

        billBoard.showWinner(views);

        verify(userOutput).show(captor.capture());

        assertThat(captor.getValue()).isEqualTo("최종 우승자 : car1");
    }
}