package service;

import domain.Track;
import domain.state.CarState;
import java.util.ArrayList;
import java.util.List;
import utils.Randoms;

public class RacingGameService {
    private Track track;

    public void trackInit(List<String> carNames){
        track = new Track();
        for(String name : carNames){
            track.addCar(name);
        }
    }

    public void step(){
        track.step(
                Randoms.pickNumbersInRange(track.getCars().size(), 0, 9)
        );
    }
}
