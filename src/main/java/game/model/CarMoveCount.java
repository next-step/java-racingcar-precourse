package game.model;

//원시값 레핑
public class CarMoveCount {
    private final int carMoveCount;

    public CarMoveCount(String inputNum){
        inputNum = inputNum.trim();
        validateIntegerCount(inputNum);
        this.carMoveCount = Integer.parseInt(inputNum);
    }

    private void validateIntegerCount(String inputNum){

        boolean isNum = inputNum.matches("[+-]?\\d*(\\.\\d+)?");
        if(!isNum) throw new IllegalArgumentException();

    }

    public int getCarMoveCount() {
        return carMoveCount;
    }
}
