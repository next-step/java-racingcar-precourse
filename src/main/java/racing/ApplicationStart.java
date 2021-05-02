package racing;

import racing.service.GameMain;

public class ApplicationStart {

    public void execute(){
        GameMain main = new GameMain();
        if(main.ready()){
            main.start();
            System.exit(0);
        }
    }

    public void gameStart(){
        while(true){
            execute();
        }
    }

    public static void main(String[] args) {
        new ApplicationStart().gameStart();
    }
}
