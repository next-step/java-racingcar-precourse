package racing;

import java.util.Arrays;

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
        return findWinnerCarsName(cars, findMaxValue(cars));
    }
    
    private int findMaxValue(Cars cars) {
        int array[] = new int[cars.getCars().size()];
        
        for (int i = 0; i < cars.getCars().size(); i++) {
            array[i] = cars.getCars().get(i).getCurrentPosition();
        }
        Arrays.sort(array);
        
        return array[array.length - 1];
    }
    
    private String findWinnerCarsName(Cars cars, int maxValue) {
        StringBuffer winnerCarsName = new StringBuffer();

        for (int i = 0; i < cars.getCars().size(); i++) {
            winnerCarsName.append(findCoWinCars(cars.getCars().get(i), maxValue));
        }
        String winner = winnerCarsName.toString();
        
        return winner.substring(0, winner.length() - 1);
    }
    
    private String findCoWinCars(Car car, int maxValue) {
        if (car.getCurrentPosition() == maxValue) {
            return car.getCarName() + ",";
        }
        return "";
    }
    
}
