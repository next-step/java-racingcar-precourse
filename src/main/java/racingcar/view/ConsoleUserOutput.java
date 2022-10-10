package racingcar.view;

public class ConsoleUserOutput implements UserOutput {
    @Override
    public void show(String text) {
        System.out.println(text);
    }
}
