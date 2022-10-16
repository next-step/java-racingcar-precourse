package racingcar.view;

public enum GameView {
    NAME_REQUEST ("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)"),
    PLAYTIME_REQUEST ("시도할 회수");
    private String message;
    GameView(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public static void showResult(GameResult winnerNames) {
        System.out.println("최종 우승자 : "+ winnerNames.getGameResult());
    }

    public static void showMessages(String message) {
        System.out.println(message);
    }

}
