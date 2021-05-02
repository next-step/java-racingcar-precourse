package racing;

import java.util.List;

public class GameController implements OnRoundStepListener{
    private Race race;
    private OutputProvider outputProvider;

    public GameController(Race race) {
        this.race = race;
        this.race.setOnRoundStepListener(this);
        this.outputProvider = new OutputProvider();
    }

    public Output flushOutput() {
        return outputProvider.getOutput();
    }

    public void setCars(CarSet cars) {
        this.outputProvider.setState(GameState.WAIT_FOR_INPUT_ROUND);
        race.setCars(cars);
    }

    public void setRound(Round round) {
        this.outputProvider.setState(GameState.READY_FOR_RESULT);
        race.setRound(round);
        race.start();
    }

    @Override
    public void onStep(CarSet carset) {
        this.outputProvider.addResult(carset);
    }

    @Override
    public void onComplete(List<Car> winners) {
        this.outputProvider.addCompleteResult(winners);
    }
}
