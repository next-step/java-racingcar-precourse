package game.view.constant;

public enum OutputMessage {

    RESULT("실행 결과"),
    WINNER("최종 우승자 : ");

    private final String description;

    OutputMessage(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
