package racingcar.vo;

abstract class Base {
    protected abstract void validate();
    protected String input;

    public Base(String input) {
        this.input = input;
        this.validate();
    }
}
