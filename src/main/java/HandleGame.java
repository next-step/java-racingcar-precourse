import java.util.ArrayList;

public class HandleGame {

    private PlayGame pg = new PlayGame();
    private ArrayList<Car> carList;

    public HandleGame(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void startGame(int cnt) {

        for (int i = 0; i < cnt; i++) {
            pg.playingGame(carList);
            System.out.println();
        }

        endGame();
    }

    public void endGame(){
        Winner win = new Winner(carList);
        ArrayList<String> winners = win.getWinners();

        System.out.print("최종 우승자 : ");

        for(String winner: winners){
            if(winners.indexOf(winner) == winners.size() - 1){
                System.out.print(winner);
                return;
            }
            System.out.print(winner + ", ");
        }

    }
}