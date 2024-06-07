package race.view;

public class InputView {
    private InputView() {}

    // 내부 클래스가 호출될 때, Instance 가 생성된다
    private static class SingletonHelper {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void inputPromptForCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputPromptForTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }
}
