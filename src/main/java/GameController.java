import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    private Scanner scanner;
    private ArrayList<Car> carList = new ArrayList<>();
    private int tryCount;

    public GameController() {
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public int getTryCount() {
        return tryCount;
    }

}
