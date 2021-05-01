package view;

import domain.Game;
import domain.Position;
import domain.Positions;
import view.print.PositionPrinter;
import view.print.WinnersPrinter;

import java.util.List;

public class PrintView {
    private Game game;
    
    public PrintView(Game game) {
        this.game = game;
    }

    public void printMoveHistories() {
        for(Positions positions : game.getMoveHistories()) {
            printPositions(positions);
            System.out.println();
        }
    }

    public void printWinners() {
        WinnersPrinter winnersPrinter = new WinnersPrinter(game.getWinners());
        System.out.println(winnersPrinter);
    }

    private void printPositions(Positions positions) {
        for(Position position : positions.getPositions()) {
            System.out.println(new PositionPrinter(position));
        }
    }
}
