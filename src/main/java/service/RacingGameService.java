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

    public void runStep(){
        track.runStep(
                Randoms.pickNumbersInRange(track.getCars().size(), 0, 9)
        );
    }

    public List<CarState> getCars(){
        var cars = track.getCars();
        return new ArrayList<>(cars);
    }
    public List<CarState> getWinners(){
        var winners = track.getWinners();
        return new ArrayList<>(winners);
    }
}
