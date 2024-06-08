package Service;

import java.util.List;

public interface RacingService {

    void setRace(String names, int time) throws IllegalArgumentException;

    void play();

    List<String> getResult();
}
