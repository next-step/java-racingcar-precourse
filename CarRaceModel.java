import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRaceModel {
    private List<String> carList; // 사용자 입력값 / 자동차 이름
    private List<String> carRaceInfo; // 자동차마다의 레이스 상황값
    private Random random;
    private int winnerLen = 0; // 레이스에서의 최대 길이

    public CarRaceModel(List<String> carList) {
        this.carList = carList;
        this.carRaceInfo = new ArrayList<>(carList.size());
        for (int i = 0; i < carList.size(); i++) {
            this.carRaceInfo.add("");
        }
        this.random = new Random();
    }

    public void race() {
        for (int i = 0; i < carList.size(); i++) {
            raceStart(i);
        }
    }

    private void raceStart(int i) {
        int randomNumber = random.nextInt(10);
        if (randomNumber <= 4) {
            carRaceInfo.set(i, carRaceInfo.get(i) + "-");
            winnerLen = Math.max(winnerLen, carRaceInfo.get(i).length());
        }
    }

    public List<String> getCarList() {
        return carList;
    }

    public List<String> getCarRaceInfo() {
        return carRaceInfo;
    }

    public int getWinnerLength() {
        return winnerLen;
    }
}
