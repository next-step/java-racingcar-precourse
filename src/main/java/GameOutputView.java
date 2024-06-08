import java.util.ArrayList;
import java.util.List;

public class GameOutputView {

    public void printPlayResult(Car[] carList) {
        for (Car car : carList) {
            String carName = car.getCarName();
            int moveCount = car.getMoveCount();

            String moveCountSymbol = "";

            for (int i = 0; i < moveCount; i++) {
                moveCountSymbol += "-";
            }

            System.out.println(carName + " : " + moveCountSymbol);
        }
        System.out.println();
    }

    public void printWinner(Car[] carList, int winnerMoveCount) {
        System.out.print("최종 우승자 : ");

        List<String> winners = new ArrayList<String>();

        for (Car car : carList) {
            int carMoveCount = car.getMoveCount();

            if (carMoveCount == winnerMoveCount) {
                winners.add(car.getCarName());
            }
        }

        System.out.println(String.join(", ", winners));
    }
}
