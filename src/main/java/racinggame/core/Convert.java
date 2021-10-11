package racinggame.core;

import java.util.List;

public class Convert {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    private final String input;

    private boolean converted = false;
    private List<Player> convertedPlayers;
    private Attempt convertedAttempt;

    public Convert(final String input) {
        this.input = input;
    }

    public boolean isConverted() {
        return this.converted;
    }

    public List<Player> getConvertedPlayers() {
        return this.convertedPlayers;
    }

    public Attempt getAonvertedAttempt() {
        return this.convertedAttempt;
    }

    private void changeConverted(final boolean converted) {
        this.converted = converted;
    }

    /**
     * 생성자로 주입받은 input 문자열을 PlayerName 컬렉션으로 변환
     * 변환에 성공할 경우 converted 값도 true로 바꿔준다
     * 변환에 실패할 경우 converted 값도 false로 바꿔준다
     */
    public void checkConvertInputNames() {
        try {
            List<PlayerName> playerNames = new PlayerNames(this.input).getPlayerNames();
            this.convertedPlayers = Player.getPlayersByPlayerNames(playerNames);
            changeConverted(true);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            changeConverted(false);
        }
    }

    /**
     * 생성자로 주입받은 input 문자열을 Attempt 객체로 변환
     * 변환에 성공할 경우 converted 값도 true로 바꿔준다
     * 변환에 실패할 경우 converted 값도 false로 바꿔준다
     */
    public void checkConvertInputCount() {
        try {
            this.convertedAttempt = new Attempt(this.input);
            changeConverted(true);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            changeConverted(false);
        }
    }

}
