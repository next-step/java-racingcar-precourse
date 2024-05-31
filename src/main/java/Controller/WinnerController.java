package Controller;

import DTO.Car;
import Service.WinnersService;
import View.Print;
import java.util.List;

public class WinnerController {

    Print print = new Print();
    WinnersService winner = new WinnersService();

    public void getWinner(List<Car> cars) {
        print.printWinners(winner.getWinner(cars));
    }
}
