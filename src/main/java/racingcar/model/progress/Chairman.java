package racingcar.model.progress;

public class Chairman {
    private final Participants participants;
    private final Judge judge;

    public Chairman(Participants participants, Judge judge) {
        this.participants = participants;
        this.judge = judge;
    }

    public void progress() {
        participants.move();
    }

    public RaceScore report() {
        RaceSituation raceSituation = participants.getRaceSituation();
        return raceSituation.report(judge);
    }

    public RaceScore reportLeads() {
        RaceScore raceScore = this.report();
        return raceScore.getLeads();
    }
}
