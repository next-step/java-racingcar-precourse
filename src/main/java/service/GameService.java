package service;

import camp.nextstep.edu.missionutils.Console;
import domain.Car;
import domain.Game;
import utils.CheckNumber;
import utils.SplitCarName;
import view.GameMessage;
import view.SystemMessage;

import java.util.Map;

public class GameService {

   Car car;
   GameMessage gameMessage = new GameMessage();
   SystemMessage systemMessage = new SystemMessage();
   SplitCarName splitCarName;
   CheckNumber checkNumber;
   private int gameNumber;

   Game game;
   public void setGame(){
      car = setCarName();
      gameNumber = setGameNumber();
      game = new Game(car,0,9);
   }
   public void playGame(){
      for(int i =0 ;i < gameNumber;i ++){
         game.challengeMove();
         showState(game.getCarState(),car);
         systemMessage.lineChange();
      }
   }

   public void endGame(){
      gameMessage.showWinner(game.getWinner());

   }

   private void showState(Map<String, Integer> carState, Car car) {
      for(String carName : car.getCars()){
         gameMessage.getCarState(carName,carState.get(carName));
      }

   }

   private int setGameNumber() {
      gameMessage.getGameNumberMessage();
      return getGameNumberByUser(Console.readLine());
   }

   private int getGameNumberByUser(String input) {
      checkNumber = new CheckNumber(input);
      try {
         int getNumber = checkNumber.getNumber();
         return getNumber;
      } catch (IllegalArgumentException e){
         systemMessage.getExceptionMessage(e.getMessage());
         return setGameNumber();
      }

   }

   private Car setCarName() {
      gameMessage.getCarNAmeMessage();
      return getCarNameByUser(Console.readLine());
   }

   private Car getCarNameByUser(String input) {
      try {
         splitCarName = new SplitCarName(input);
         car = new Car(splitCarName.getCarName());
         return car;
      } catch (IllegalArgumentException e){
         systemMessage.getExceptionMessage(e.getMessage());
         return setCarName();
      }

   }

}


