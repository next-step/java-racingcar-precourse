import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
    public final ByteArrayOutputStream output=new ByteArrayOutputStream();
    Name name = new Name();
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }
    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }
    @Test
    @DisplayName("길이 오류 체크.")
    void getName_lengthError(){
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("harrison");
            name.inputNames();
        });
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("margarate");
            name.inputNames();
        });
    }
    @Test
    @DisplayName("쉼표 입력과 이름 입력 오류")
    void getName_ExtraErrors(){
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("harry,son,");
            name.inputNames();
        });
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("harry,,anne");
            name.inputNames();
        });
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("harry anne");
            name.inputNames();
        });
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("harry#Jess#Vicky");
            name.inputNames();
        });
    }
    @Test
    @DisplayName("숫자가 아닌 값 입력시 오류.")
    void getNum_numericError(){
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("ad");
            name.inputNum();
        });
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("1a");
            name.inputNum();
        });
    }
    @Test
    @DisplayName("우승자 출력 확인")
    void getWinner(){
        name.NAME=new String[3];
        name.RACE=new String[3];
        name.RACE_COUNT=new int[3];
        Arrays.fill(name.RACE, "");
        Arrays.fill(name.RACE_COUNT, 0);

        name.NAME[0]="harry";
        name.NAME[1]="tom";
        name.NAME[2]="jess";
        name.RACE[0]="---";
        name.RACE[1]="-";
        name.RACE[2]="---";
        name.RACE_COUNT[0]=3;
        name.RACE_COUNT[1]=1;
        name.RACE_COUNT[2]=3;
        name.WINNER="";
        name.MAX=3;
        name.getWinner();
        assertThat(output.toString().trim())
            .isEqualTo("최종 우승자 : harry, jess");
        restoreOutputStream();

        name.NAME[0]="harry";
        name.NAME[1]="tom";
        name.RACE[0]="---";
        name.RACE[1]="----";
        name.RACE_COUNT[0]=3;
        name.RACE_COUNT[1]=4;
        name.WINNER="";
        name.MAX=4;
        name.getWinner();
        assertThat(output.toString().trim())
            .isEqualTo("최종 우승자 : tom");
        restoreOutputStream();
    }


}
