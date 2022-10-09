package racingcar.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputStringTest {


    @Test
    void 입력문자가_null인지확인(){

        try {
            InputString.isNull("");
        }catch (IllegalArgumentException e) {
            assertThat(e).
                    isInstanceOf(IllegalArgumentException.class);
        }
    }



}
