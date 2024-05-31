package Controller;

import DTO.Car;
import Service.WinnersService;
import View.Print;
import java.util.List;

public class WinnerController {

    Print print = new Print();
    WinnersService winner = new WinnersService();

//    가장 많이 나아간 자동차 명들을 출력한다.
    public void getWinner(List<Car> cars) {
        print.printWinners(winner.getWinner(cars));
    }
}
