package racing.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    @DisplayName("참가자명 길이 에러")
    public void nameLengthError(){
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("jordan");
        });
    }

    @Test
    @DisplayName("참가자명 정상 입력")
    public void inputName(){
        String name = "messi";
        Car car = new Car(name);
        assertEquals(name,car.getCarName());
    }

    @Test
    @DisplayName("여러 참가자들을 접수")
    public void inputNames(){
        String names = "lucas,son,kane,mane";
        int nameSize = names.split(",").length;
        Reception reception = new Reception(new ArrayList<>());
        reception.register(names);
        assertEquals(nameSize,reception.getParticipants().size());
    }
}
