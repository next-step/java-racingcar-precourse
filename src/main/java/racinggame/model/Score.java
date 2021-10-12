package racinggame.model;

public class Score {
    private Integer runNumber;
    private Boolean victory;

    public Score(Integer runNumber, Boolean victory) {
        this.runNumber = runNumber;
        this.victory = victory;
    }

    public Integer getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(Integer runNumber) {
        this.runNumber = runNumber;
    }

    public Boolean getVictory() {
        return victory;
    }

    public void setVictory(Boolean victory) {
        this.victory = victory;
    }
}
