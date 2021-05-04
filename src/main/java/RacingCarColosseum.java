public class RacingCarColosseum {
    private static final String GAME_TURN_HEAD_MSG_FORMAT = "[%d 번째 시도]";
    private static final String START_GAME_HEADER_MSG = "[ 실행 결과 ]";

    private RandomGenerator randomGenerator;

    public RacingCarColosseum(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public CarPlayerContainer play(PlayerNameContainer playerNames, TrialCount trialCount) {
        CarPlayerContainer carPlayers = this.createCarPlayers(playerNames);

        System.out.println(START_GAME_HEADER_MSG);
        proceedGameTurns(carPlayers, trialCount);

        return carPlayers.getWinners();
    }

    private CarPlayerContainer createCarPlayers(PlayerNameContainer playerNames) {
        CarPlayerContainer carPlayers = new CarPlayerContainer();

        for (PlayerName playerName : playerNames.getNames()) {
            carPlayers.add(new CarPlayer(playerName, this.randomGenerator));
        }

        return carPlayers;
    }

    private void proceedGameTurns(CarPlayerContainer carPlayers, TrialCount trialCount) {
        for (int i = 0; i < trialCount.getTrialCount(); i++) {
            System.out.println(String.format(GAME_TURN_HEAD_MSG_FORMAT, i + 1));
            this.proceedGameTurn(carPlayers);
            System.out.println();
        }
    }

    private void proceedGameTurn(CarPlayerContainer carPlayers) {
        for (CarPlayer player : carPlayers.getPlayers()) {
            player.tryMoveCar();
            System.out.println(player.toString());
        }
    }
}
