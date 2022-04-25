package racingcar.participant;

public class PresentationalRacingCar implements Participant {

    private final String name;
    private final String report;

    public PresentationalRacingCar(String name, String report) {
        this.name = name;
        this.report = report;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean process(Integer randomNumber) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String report() {
        return report;
    }

}
