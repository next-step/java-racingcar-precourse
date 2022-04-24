package racingcar.model;

public class Racing {

    private Racers racers;

    public Racing(Racers racers) {
        this.racers = racers;
    }

    public void result(Attempts attempts) {
        for (int i = 0; i < attempts.getAttempt(); i++) {
            racers.race();
            System.out.println();
        }
        Winners winner = racers.winner();
        winner.printWinners();

    }
}
