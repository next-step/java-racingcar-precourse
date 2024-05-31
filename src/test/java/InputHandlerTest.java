import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import java.io.*;
import java.util.*;

public class InputHandlerTest {

    private InputHandler inputHandler;

    @Test
    public void testGetRacersFromUser() {
        String input = "kim,Seo,jiu";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputHandler = new InputHandler(new Scanner(System.in));

        //getRacersFromUser: 문자열 상태 => 벡터에 racer들이 잘 넣어졌는지 확인하기
        Vector<Racer> racers = inputHandler.getRacersFromUser();
        assertThat(racers).hasSize(3);
        assertThat(racers.get(0).name).isEqualTo("kim");
        assertThat(racers.get(1).name).isEqualTo("Seo");
        assertThat(racers.get(2).name).isEqualTo("jiu");
    }

    @Test
    public void testCreateRacers() {
        String[] names = {"kim", "Seo", "jiu"};
        inputHandler = new InputHandler(new Scanner(System.in));

        //createRacers: 배열 상태 => 벡터에 racer들이 잘 넣어졌는지 확인하기
        Vector<Racer> racers = inputHandler.createRacers(names);
        assertThat(racers).hasSize(3);
        assertThat(racers.get(0).name).isEqualTo("kim");
        assertThat(racers.get(1).name).isEqualTo("Seo");
        assertThat(racers.get(2).name).isEqualTo("jiu");
    }

    @Test
    public void testValidateNames_ValidNames() {
        String[] validNames = {"지우", "서지우", "서"};
        inputHandler = new InputHandler(new Scanner(System.in));
        inputHandler.validateNames(validNames);
        // 예외가 발생하지 않으면 테스트 통과
        //5 초과, 공백 오류 잡기
    }

    @Test
    public void testValidateNames_InvalidNames() {
        String[] invalidNames = {"seo", "jiu Seo", "jiu"};
        inputHandler = new InputHandler(new Scanner(System.in));
        assertThatThrownBy(() -> inputHandler.validateNames(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 이내, 공백 불가.");
        //예외 발생시 테스트 통과
    }


}