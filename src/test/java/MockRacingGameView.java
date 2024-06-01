import java.util.ArrayList;
import java.util.List;

public class MockRacingGameView extends RacingGameView {
    private List<String> carNames;
    private int moveCount;
    private List<Car> printedCars=new ArrayList<>();
    private List<Car> winners=new ArrayList<>();

    public void setCarNames(List<String> carNames){
        this.carNames=carNames;
    }

    public void setMoveCount(int moveCount){
        this.moveCount=moveCount;
    }

    public List<Car> getPrintedCars(){
        return printedCars;
    }

    public List<Car> getWinner(){
        return winners;
    }

    @Override
    public List<String> getCarNames(){
        return carNames;
    }

    @Override
    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public void printProgress(List<Car> cars){
        printedCars.addAll(cars);
    }

    @Override
    public void printWinner(List<Car> winner){
        winners.addAll(winner);
    }
}
