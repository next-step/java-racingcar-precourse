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
        assertThat(gameController.getCarNames("a,b")).containsOnly("a", "b");
        assertThat(gameController.getCarNames("가,나")).containsOnly("가", "나");
        assertThat(gameController.getCarNames("aaaaa,bbbbb")).containsOnly("aaaaa", "bbbbb");
        assertThat(
            gameController.getCarNames("aaa,bbb,ccc,ddd,eee,fff,ggg,iii,hhh,kkk")
        ).containsOnly("aaa","bbb","ccc","ddd","eee","fff","ggg","iii","hhh","kkk");

        // 구분자 사이에 공백은 허용
        assertThat(gameController.getCarNames("abc,acb")).containsOnly("abc", "acb");
        assertThat(gameController.getCarNames("abc, acb")).containsOnly("abc", "acb");
        assertThat(gameController.getCarNames("abc ,acb")).containsOnly("abc", "acb");
        assertThat(gameController.getCarNames("abc , acb")).containsOnly("abc", "acb");

    }

    @Test
    void invalidCarName() {
        // 구분자 사이에 이름 없음
        assertThatThrownBy(
            () -> gameController.getCarNames(",")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getCarNames(",aaa")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,")
        ).isInstanceOf(IllegalArgumentException.class);

        // 빈 문자열 입력
        assertThatThrownBy(
            () -> gameController.getCarNames("")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,,bbb")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getCarNames("aaa, ,bbb")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,,,,,bbb")
        ).isInstanceOf(IllegalArgumentException.class);

        // 중복 입력
        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,aaa")
        ).isInstanceOf(IllegalArgumentException.class);

        // 이름 길이 초과
        assertThatThrownBy(
            () -> gameController.getCarNames("aaaaaa,bbb")
        ).isInstanceOf(IllegalArgumentException.class);

        // 이름 입력 개수 미달
        assertThatThrownBy(
            () -> gameController.getCarNames("aaa")
        ).isInstanceOf(IllegalArgumentException.class);
        // 이름 입력 개수 초과
        assertThatThrownBy(
            () -> gameController.getCarNames("aaa,bbb,ccc,ddd,eee,fff,ggg,iii,hhh,kkk,lll")
        ).isInstanceOf(IllegalArgumentException.class);


    }


}
