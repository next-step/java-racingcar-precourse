package racinggame.control;

import racinggame.car.CarList;
import racinggame.car.GameCount;

public class CurrentGameInfo {
    private GameStatus status;
    private CarList list;
    private GameCount count;

    public CurrentGameInfo() {
        status = GameStatus.INIT;
        list = new CarList();
        count = new GameCount();
    }

    public GameStatus getStatus() {
        return status;
    }

    public CarList getList() {
        return list;
    }

    public GameCount getCount() {
        return count;
    }

    public void setCount(GameCount count) {
        this.count = count;
    }

    public void setList(CarList list) {
        this.list = list;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

}
