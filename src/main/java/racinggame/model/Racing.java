package racinggame.model;

import java.util.ArrayList;

public class Racing {

    public static String getWinner(ArrayList<Car> cars) {
        int maxScore = 0;
        String winner = "";

        for(Car car : cars) {
            maxScore = maxScore > car.getScore() ? maxScore : car.getScore();
        }

        for(Car car : cars) {
            if(car.getScore() == maxScore) {
                winner += car.getName() + ",";
            }
        }

        return winner.substring(0, winner.length()-1);
    }

    public static MoveStatus goOrStop(int val) {
        if(val > 4) {
            return MoveStatus.GO;
        }
        return MoveStatus.STOP;
    }
}
