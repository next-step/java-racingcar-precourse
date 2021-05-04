public class GameMain {

    static GameIO io;
    static GameHandler handler;

    public static void init() {
        io = new GameIO();
        handler = new GameHandler();
    }

    public static void main(String[] args) {
        init();
        io.printInputName();
        handler.addCar(io.inputFromUser());
        io.printInputTryNumber();
        io.printResult(handler.doRacing(Integer.parseInt(io.inputFromUser())));
        io.printWinner(handler.getWinners());
    }
}
