package racingcar.view;

public class ErrorView extends RacingCarView{

    public void print(String message) {
        System.out.println("[ERROR]" + "시스템 오류가 발생하였습니다. " + message);
    }
}
