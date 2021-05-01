import java.util.Arrays;

public class GameView {
    public Game game;

    public void GameViewStart(){
        game = new Game();
        game.carNameInput();
        game.randomInitCountInput();
        this.GameViewResult();
    }

    public void GameViewResult(){
        for(int i=0;i<game.gameCount;i++){
            this.GameRoundRandom();
            this.GameViewString();
        }
        System.out.println(this.GameViewVictory());
    }

    public void GameRoundRandom(){
        for(int i=0;i<game.carObject.getCarListLength();i++){
            game.randomCountResult(i);
        }
    }

    public void GameViewString(){
        for(int i=0;i<game.carObject.getCarListLength();i++){
            System.out.println(game.viewStringResult(i));
        }
        System.out.println("");
    }

    public String GameViewVictory(){
        int maxCount = game.returnMaxCount();
        String[] victoryList = this.GameMaxCountCaulator(maxCount).split(",");
        String victoryString = victoryList[0];
        for(int i=1;i<victoryList.length;i++){
            victoryString += ",";
            victoryString += victoryList[i];
        } victoryString += "가 최종 우승했습니다.";
        return victoryString;
    }

    public String GameMaxCountCaulator(int maxCount){
        boolean[] victoryBoolean = new boolean[game.carObject.getCarListLength()];
        String victoryString = "";
        for(int i=0;i<game.carObject.getCarListLength();i++) {
            victoryBoolean[i] = game.returnIndexCount(maxCount,i);
            victoryString += game.returnCalulatorString(victoryBoolean[i],i);
        }
        return victoryString;
    }



}
