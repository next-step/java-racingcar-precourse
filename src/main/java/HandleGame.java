import java.util.ArrayList;
import java.util.Scanner;

public class HandleGame {

    private PlayGame pg = new PlayGame();
    InputCarName icn = new InputCarName();
    Scanner sc = new Scanner(System.in);
    IsValidInput ivi = new IsValidInput();

    private ArrayList<Car> carList = new ArrayList<>();

    public HandleGame() {
    }

    public void Game(){

        boolean fail = true;

        while(fail){
            try{
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String names = sc.nextLine();
                ivi.isValidNames(names);
                fail = false;
                setGame(names);
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        fail = true;

        while (fail) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                String cnt = sc.next();
                ivi.isValidCnt(cnt);
                fail = false;
                startGame(Integer.parseInt(cnt));
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }
        }


        endGame();

    }

    public void setGame(String names) {

        icn.splitInput(names);
        carList = icn.getCarList();

    }

    public void startGame(int cnt){

        for (int i = 0; i < cnt; i++) {
            pg.playingGame(carList);
            System.out.println();
        }

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