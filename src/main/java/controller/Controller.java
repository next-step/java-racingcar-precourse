package controller;

import domain.Car;
import domain.Game;
import java.util.List;
import repository.CarRepository;
import util.Input;
import view.OutputView;

public class Controller {
  private final Input input = new Input();
  private final CarRepository cars = new CarRepository();
  private final OutputView outputView = new OutputView();
  public void run(){
    saveCars(input.getCarNames());
    Game game = createGame(cars.findAll(),input.getNumberOfAttempts());
    game.playGame();
    outputView.printWinners(game.getWinners());
  }

  private void saveCars(List<String> names){
    for(String name: names) {
      cars.save(new Car(name));
    }
  }

  private Game createGame(List<Car> cars,int numberOfAttempts){
    return new Game(cars,numberOfAttempts);
  }
}
