package view;

import domain.CarHistories;
import domain.CarHistory;
import domain.Game;
import domain.Position;
import view.print.PositionPrinter;
import view.print.WinnersPrinter;

public class PrintView {
    private Game game;
    
    public PrintView(Game game) {
        this.game = game;
    }

    public void printMoveHistories() {
        for(CarHistories carHistories : game.getMoveHistories()) {
            printPositions(carHistories);
            System.out.println();
        }
    }

    public void printWinners() {
        WinnersPrinter winnersPrinter = new WinnersPrinter(game.getWinners());
        System.out.println(winnersPrinter);
    }

    private void printPositions(CarHistories carHistories) {
        for(CarHistory carHistory : carHistories.getCarHistories()) {
            System.out.println(new PositionPrinter(carHistory));
        }
    }
}
