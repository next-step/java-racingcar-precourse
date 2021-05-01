public class RacingGameMain {

    public static void main(String[] args){
        try {
            Game game = new Game();
            game.GameStart();
        }catch(Exception e){
            System.out.print("This Error : ");
            e.printStackTrace();
        }
    }
}
