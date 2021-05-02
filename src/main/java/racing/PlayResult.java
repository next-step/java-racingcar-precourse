package racing;

public class PlayResult {

    public static final String FINAL_WINNER_ANNOUNCE_MESSAGE = "가 최종 우승했습니다";

    public void printCurrentStatus(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.println(cars.getCars().get(i).getCarName() + " : "
                    + viewMoveCount(cars.getCars().get(i).getCurrentPosition()));
        }
        System.out.print("\n");
    }
    
    public void printFinalResult(Cars cars) {
        String winnerCars = findWinner(cars);
        System.out.println(winnerCars + FINAL_WINNER_ANNOUNCE_MESSAGE);
    }
    
    private String viewMoveCount(int moveCount) {
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < moveCount; i++) {
            buffer.append("-");
        }
        
        return buffer.toString();
    }
    
    private String findWinner(Cars cars) {
        StringBuffer winnerCarsName = new StringBuffer();
        int maxValue = 0;

        for(int i = 0; i < cars.getCars().size(); i++) {
            maxValue = findMaxValue(cars.getCars().get(i), maxValue);
        }
        for(int i = 0; i < cars.getCars().size(); i++) {
            winnerCarsName.append(findCoWinCars(cars.getCars().get(i), maxValue));
        }
        
        String winnerList = winnerCarsName.toString();
        
        return winnerList.substring(0, winnerList.length()-1);
    }
    
    private int findMaxValue(Car car, int maxValue) {
        if(car.getCurrentPosition() >= maxValue) {
            maxValue = car.getCurrentPosition();
        }
        return maxValue;
    }


    private String findCoWinCars(Car car, int maxValue) {
        if(car.getCurrentPosition() == maxValue) {
            return car.getCarName() + ",";
        }
        return "";
    }
    
}
