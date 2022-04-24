package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarResults {

    private static final int END_GAME = 0;
    private final List<CarResult> carResults;
    private int gameRound;

    public CarResults(int count, String gameRound){
        this.carResults = makeCarResults(count);
        validGameRoundInput(gameRound);
        this.gameRound = Integer.valueOf(gameRound);
    }

    public List<CarResult> getCarResults() {
        return carResults;
    }

    private static List<CarResult> makeCarResults(int count){
        List<CarResult> carResultList = new ArrayList<>();
        for (int i=0; i<count; ++i){
            carResultList.add(new CarResult());
        }

        return carResultList;
    }

    public boolean isGameEnd(){
        return gameRound == END_GAME;
    }

    public void playMove(List<CarStatus> moveCommandList) {

        for(int i=0; i<moveCommandList.size(); ++i){
            CarStatus status = moveCommandList.get(i);
            carResults.get(i).move(status);
        }

        reduceGameRound();
    }

    private void reduceGameRound() {
        gameRound -= 1;
    }

    public CarResult getIndexOfResult(int index){
        return carResults.get(index);
    }

    public List<Boolean> getWinnerIndex() {
        List<Boolean> winnerist = new ArrayList<>();

        int maxMove = getMaxMove();
        for(CarResult carResult : carResults){
            winnerist.add(carResult.isWinner(maxMove));
        }

        return winnerist;
    }

    private int getMaxMove() {

        int max = 0;
        for(CarResult carResult : carResults){
            max = Math.max(max, carResult.getLocation());
        }

        return max;
    }

    private void validGameRoundInput(String gameRound) {

        if(!ValidUtils.isNumber(gameRound)) {
            throw new IllegalStateException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if(!ValidUtils.isPlus(gameRound)){
            throw new IllegalStateException("[ERROR] 양수만 입력 가능합니다.");
        }
    }
}
