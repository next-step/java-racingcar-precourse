import static org.assertj.core.api.Assertions.*;

import controller.GameController;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameInputTest {

    GameController gameController;

    public CarNameInputTest() {
        this.gameController = new GameController();
    }

    @Test
    void validCarName() {
        assertThat(gameController.parseInputs("abc,acb")).containsOnly("abc", "acb");
        assertThat(gameController.parseInputs("abc, acb")).containsOnly("abc", "acb");
        assertThat(gameController.parseInputs("abc ,acb")).containsOnly("abc", "acb");
        assertThat(gameController.parseInputs("abc , acb")).containsOnly("abc", "acb");
        assertThat(
            gameController.parseInputs("aaa,bbb,ccc,ddd,eee,fff,ggg,iii,hhh,kkk")
        ).containsOnly("aaa","bbb","ccc","ddd","eee","fff","ggg","iii","hhh","kkk");
    }

    @Test
    void invalidCarName() {
        assertThatThrownBy(
            () -> gameController.parseInputs("")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.parseInputs("aaa")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.parseInputs(",")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.parseInputs(",aaa")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.parseInputs("aaa,")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.parseInputs("aaa,,bbb")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.parseInputs("aaa,,,,,bbb")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.parseInputs("aaa,aaa")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.parseInputs("aaaaaa,bbb")
        ).isInstanceOf(IllegalArgumentException.class);


        assertThatThrownBy(
            () -> gameController.parseInputs("aaa,bbb,ccc,ddd,eee,fff,ggg,iii,hhh,kkk,lll")
        ).isInstanceOf(IllegalArgumentException.class);


    }


}
