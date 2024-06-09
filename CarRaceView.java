import java.util.List;

public class CarRaceView {
    public void printRaceInfo(List<String> carList, List<String> carRaceInfo) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i) + " : " + carRaceInfo.get(i));
        }
        System.out.println();
    }

    public void printResult(List<String> carList, List<String> carRaceInfo, int winnerLen) {
        boolean firstWinner = true;
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < carList.size(); i++) {
            if (carRaceInfo.get(i).length() == winnerLen) {
                if (firstWinner) {
                    firstWinner = false;
                    System.out.print(carList.get(i));
                    continue;
                }
                System.out.print(", " + carList.get(i));
            }
        }
    }
}
