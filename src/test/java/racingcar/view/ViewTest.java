package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.utils.Contant.*;

public class ViewTest {
    private View view = new View();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
        outputStreamCaptor.reset();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong"})
    void 자동차_이름_입력_화면(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);

        String[] names = view.inputCarNameView();
        assertEquals(VIEW_INPUT_NAMES, outputStreamCaptor.toString().trim());
        assertEquals(3, names.length);
        assertEquals("pobi", names[0]);
        assertEquals("honux", names[1]);
        assertEquals("crong", names[2]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaji"})
    void 자동차_이름_길이_5자_초과(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputCarNameView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains(ERROR_INPUT_NAME_LENGTH);
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n"})
    void 자동차_이름_길이_1자_미만(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputCarNameView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains(ERROR_INPUT_NAME_LENGTH);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi"})
    void 자동차_이름_중복_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputCarNameView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains(ERROR_INPUT_DUPLICATED);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5"})
    void 시도_횟수_입력_화면(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { assertEquals(5, view.inputTryCountView()); } catch (final NoSuchElementException ignore){}
        assertEquals(VIEW_INPUT_TRY_COUNT, outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1"})
    void 시도_횟수_음수_입력(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputTryCountView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains(ERROR_INPUT_NOT_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void 시도_횟수_문자_입력(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputTryCountView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains(ERROR_INPUT_NOT_NUMBER);
    }
}
