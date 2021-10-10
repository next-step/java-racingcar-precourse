package racinggame.control;

import racinggame.Service;

import java.util.HashMap;
import java.util.Map;

public class ControllerMapper {

    Map<GameStatus, Service> map = new HashMap<>();

    public void put(GameStatus status, Service runnable) {
        map.put(status, runnable);
    }

    public Service get(GameStatus status) {
        return map.get(status);
    }


}
