package kim.half;


import kim.half.controller.GameManager;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.startGame();
    }
}
