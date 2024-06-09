package service;

import domain.Track;
import java.util.List;

public class RacingGameService {
    private Track track;

    public void trackInit(List<String> carNames){
        track = new Track();
        for(String name : carNames){
            track.addCar(name);
        }
    }
}
