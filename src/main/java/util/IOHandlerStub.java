package util;

public class IOHandlerStub extends IOHandler {

    private final String input;
    private final int intInput;

    public IOHandlerStub(String input, int intInput) {
        this.input = input;
        this.intInput = intInput;
    }

    @Override
    public void println(String message) {
        // 테스트용으로는 출력하지 않음
    }

    @Override
    public String getStringInput() {
        return input;
    }

    @Override
    public int getIntInput() {
        return intInput;
    }
}
