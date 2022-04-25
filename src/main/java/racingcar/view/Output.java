package racingcar.view;

public class Output {

    public void showNotice(String str) {
        System.out.println(str);
    }

    public void showError(Throwable e) {
        System.out.println(e.getMessage());
    }
}
