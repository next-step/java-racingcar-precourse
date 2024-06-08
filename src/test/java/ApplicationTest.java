import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApplicationTest {
    @Test
    void 게임진행(){
        // given
        run();
        // when

        // then

    }

    @Test
    void 모킹_테스트(){
        List<String> mock = Mockito.mock(List.class);
        when(mock.get(0)).thenReturn("Hello, Mockito!");

        assertEquals("Hello, Mockito!", mock.get(0));

        verify(mock, times(1)).get(0);
    }

}
