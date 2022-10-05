package racingcar.ui;

import static java.lang.System.out;

import racingcar.service.RacingCarService;

public class TrackView {
    private final RacingCarService racingCarService;

    public TrackView(RacingCarService racingCarService){
        this.racingCarService = racingCarService;
    }

    /**
     * print race circuit track
     */
    public void printTrack(){
        out.println("실행 결과");
        while(racingCarService.haveLaps()){
            racingCarService.race();
            String[] trackStatus = racingCarService.getCurrentTrackStatus();
            for (int i = 0; i <trackStatus.length; i++) {
                out.println(trackStatus[i]);
            }
            out.println();
        }
    }

    /**
     * print final winners
     */
    public void printWinner(){
        out.println(racingCarService.getWinnerListString());
    }
}
