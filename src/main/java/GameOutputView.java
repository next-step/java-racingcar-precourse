public class GameOutputView {
    public void printPlayResult(Car[] carList) {
        for (Car car : carList) {
            String carName = car.getCarName();
            int moveCount = car.getMoveCount();

            String moveCountSymbol = "";

            for (int i=0; i<moveCount; i++) {
                moveCountSymbol += "-";
            }

            System.out.println(carName + " : " + moveCountSymbol);
        }
        System.out.println();
    }
}
