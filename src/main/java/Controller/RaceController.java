package Controller;

import Model.Car;
import Model.Race;
import View.Input;
import View.Output;

import java.util.ArrayList;
import java.util.List;

public class RaceController {

    //정상적으로 입력받아 car 구축
    private List<Car> createCars(){
        while(true){
            try{
                String[] carNames = Input.getCarName();
                List<Car> cars = new ArrayList<>();
                for(int i = 0; i < carNames.length; i++){
                    cars.add(new Car(carNames[i]));
                }
                return cars;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private int getMove(){
        while (true){
            try{
                return Input.getMoveNumber();
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }


    public void starGame(){
        List<Car> cars = createCars();
        int moves = getMove();
        Race race = new Race(cars, moves);

        race.startRace();
        Output.printCarStatus(cars);
        Output.printRacingWinner(race.getWinners());
    }
}
