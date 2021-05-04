import view.InputView;

public class Main {


    public static void main(String[] args) {

        InputView inputView = new InputView();
        String[] carNames = inputView.inputCarParticipateInRacingGame();

        for(String name: carNames){
            System.out.println(name);
        }

    }
}
