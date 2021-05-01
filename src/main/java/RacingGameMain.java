public class RacingGameMain {

    public static void main(String[] args){
        try {
            GameView gameView = new GameView();
            gameView.GameViewStart();
        }catch(Exception e){
            System.out.print("This Error : ");
            e.printStackTrace();
        }
    }
}
