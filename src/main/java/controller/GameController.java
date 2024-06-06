package controller;

import service.GameService;
import view.GameView;

public class GameController {
    private GameView view;
    private GameService service;

    /**
     * GameController 생성자
     *
     * @param view GameView
     * @param service GameService
     */
    public GameController(GameView view, GameService service) {
        this.view = view;
        this.service = service;
    }

}
