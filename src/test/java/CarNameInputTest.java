import static org.assertj.core.api.Assertions.*;

import controller.GameController;
import org.junit.jupiter.api.Test;

public class CarNameInputTest {

    GameController gameController;

    public CarNameInputTest() {
        this.gameController = new GameController();
    }

    @Test
    void validCarName() {
        assertThat(gameController.getCarNames("abc,acb")).containsOnly("abc", "acb");
        assertThat(gameController.getCarNames("abc, acb")).containsOnly("abc", "acb");
        assertThat(gameController.getCarNames("abc ,acb")).containsOnly("abc", "acb");
        assertThat(gameController.getCarNames("abc , acb")).containsOnly("abc", "acb");
        assertThat(
            gameController.getCarNames("aaa,bbb,ccc,ddd,eee,fff,ggg,iii,hhh,kkk")
        ).containsOnly("aaa","bbb","ccc","ddd","eee","fff","ggg","iii","hhh","kkk");
    }

    @Test
    void invalidCarName() {
        assertThatThrownBy(
            () -> gameController.getCarNames("")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.getCarNames("aaa")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.getCarNames(",")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.getCarNames(",aaa")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,,bbb")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,,,,,bbb")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,aaa")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> gameController.getCarNames("aaaaaa,bbb")
        ).isInstanceOf(IllegalArgumentException.class);


        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,bbb,ccc,ddd,eee,fff,ggg,iii,hhh,kkk,lll")
        ).isInstanceOf(IllegalArgumentException.class);


    }


}
