import java.util.ArrayList;
import java.util.Random;

public class PlayGame {

    private Random rand = new Random();

    public PlayGame() {
    }

    public void playingGame(ArrayList<Car> carList){
        System.out.println("실행 결과");

        for(Car c: carList){
            int forwardCnt = c.movingForward(rand.nextInt(10));
            System.out.println(c.getName() + " : " + ("-".repeat(forwardCnt)));
        }
    }


}
