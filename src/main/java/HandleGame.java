public class HandleGame {

    private PlayGame pg = new PlayGame();

    public void startGame(int cnt){
        for(int i = 0; i < cnt; i++){
            pg.playingGame();
        }
    }
}
