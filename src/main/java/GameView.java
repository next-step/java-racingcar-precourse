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


}
