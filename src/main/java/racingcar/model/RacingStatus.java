package racingcar.model;

public enum RacingStatus {
    WAIT("wait"),
    PLAYING("playing"),
    END("end");

    private String status;

    private RacingStatus(String status){
        this.status = status;
    }

    public void waitRacing(){
        this.status = RacingStatus.WAIT.name();
    }

    public void startRacing(){
        this.status = RacingStatus.PLAYING.name();
    }

    public void endRacing(){
        this.status = RacingStatus.END.name();
    }

    public boolean isEnd(){
        return status.equals(RacingStatus.END.name());
    }
}
