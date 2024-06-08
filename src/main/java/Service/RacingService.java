package Service;

import java.util.List;

public interface RacingService {

    void setRace(String names, String time) throws IllegalArgumentException;

    void play();

    List<String> getResult();
}
