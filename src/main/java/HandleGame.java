import java.util.ArrayList;

public class HandleGame {

    private PlayGame pg = new PlayGame();

    public HandleGame(){
    }

    public void startGame(int cnt, ArrayList<Car> carList){
        for(int i = 0; i < cnt; i++){
            pg.playingGame(carList);
            System.out.println();
        }
    }
}
