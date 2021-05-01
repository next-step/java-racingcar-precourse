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

    @Test
    @DisplayName("자동차 위치값 호출")
    public void getPosition() throws InterruptedException {

        for(int i = 0;i<5;i++){
            Car car = new Car("lucas");
            Thread.sleep(3000);
            int randomValue = car.randomSetPosition();
            if(randomValue>=4){
                System.out.println("전진");
                assertEquals(1,car.getPosition());
            }
            if(randomValue<=3){
                System.out.println("정지");
                assertEquals(0,car.getPosition());
            }
        }
    }
}
