import Controller.RacingController;
import Utils.RandomUtil;
import Views.InputView;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApplicationTest {
    @Test
    void 게임진행(){
        // given
        RacingController rc = RacingController.getInstance();
        rc.run();
        InputView mockInputView = mock(InputView.class);
        RandomUtil mockRandomUtil = mock(RandomUtil.class);


        // when
        when(mockInputView.requestName()).thenReturn("leo,neo,geo");
        when(mockInputView.requestTime()).thenReturn("5");
        when(mockRandomUtil.getRandomArray(3, 0, 9)).thenReturn(new int[]{0,0,4});

        // then
        assertEquals();
    }

    @Test
    void 모킹_테스트(){
        List<String> mock = Mockito.mock(List.class);
        when(mock.get(0)).thenReturn("Hello, Mockito!");

        assertEquals("Hello, Mockito!", mock.get(0));

        verify(mock, times(1)).get(0);
    }

}
