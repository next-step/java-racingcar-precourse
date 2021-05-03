import java.util.List;

public class RacingCarColosseum {
    public static final String GAME_TURN_HEAD_MSG_FORMAT = "[%d 번째 시도]";
    public static final String START_GAME_HEADER_MSG = "[ 실행 결과 ]";
    private RandomGenerator randomGenerator;

    public RacingCarColosseum(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public List<CarPlayer> play(CarNameContainer carNameContainer, TrialCount trialCount) {
        CarPlayerContainer carPlayerContainer = this.createCarPlayers(carNameContainer);

        System.out.println(START_GAME_HEADER_MSG);
        proceedGameTurns(carPlayerContainer, trialCount);

        return carPlayerContainer.getWinners();
    }

    private CarPlayerContainer createCarPlayers(CarNameContainer carNameContainer) {
        CarPlayerContainer carPlayerContainer = new CarPlayerContainer();

        for (CarName carName : carNameContainer.getNames()) {
            carPlayerContainer.add(new CarPlayer(carName, this.randomGenerator));
        }

        return carPlayerContainer;
    }

    private void proceedGameTurns(CarPlayerContainer carPlayerContainer, TrialCount trialCount) {
        for (int i = 0; i < trialCount.getTrialCount(); i++) {
            System.out.println(String.format(GAME_TURN_HEAD_MSG_FORMAT, i + 1));
            this.proceedGameTurn(carPlayerContainer);
            System.out.println();
        }
    }

    private void proceedGameTurn(CarPlayerContainer carPlayerContainer) {
        for (CarPlayer player : carPlayerContainer.getPlayers()) {
            player.tryMoveCar();
            System.out.println(player.toString());
        }
    }
}
