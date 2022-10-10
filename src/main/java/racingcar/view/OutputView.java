package racingcar.view;

public class OutputView {

    public void notice(String str) {
        System.out.println(str);
    }

    public void error(Throwable e) {
        System.out.println(e.getMessage());
    }
}
