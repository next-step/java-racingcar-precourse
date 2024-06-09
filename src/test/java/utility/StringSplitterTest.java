package utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitterTest {
    StringSplitter sp = new StringSplitter();

    @Test
    @DisplayName("(,)를 기준으로 문자열 분리")
    public void splitTest(){
        // Given
        String input = "java,c , c++";
        String[] expected = {"java", "c", "c++"};

        // When
        String[] result = sp.splitter(input);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
