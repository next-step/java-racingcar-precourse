package racingcar.model;

import java.util.Arrays;
import java.util.Random;
import static racingcar.Utils_and_Message.Utils.getMax;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    private Car[] carsForGame;

    public RacingCar(Car[] carsForGame) {
        this.carsForGame = carsForGame;
    }

    public RacingCar(String[] names_arr) {
        this.carsForGame = new Car[names_arr.length];

        for(int i=0;i< names_arr.length; i++){
            this.carsForGame[i] = new Car(names_arr[i], 0);
        }
    }

    public void playRound(){
        for(Car car : carsForGame) {
            int randomNum = makeComputerNum(); // 랜덤숫자 생성
            //System.out.println("## "+car.getName()+randomNum);
            if (randomNum > 4) { // 랜덤 숫자 4 초과시 전진
                car.goForward();
            }
        }
        OutputView.printRace(carsForGame);
    }

    public static int makeComputerNum(){
        Random random = new Random();
        return random.nextInt(10);
    }

    public int getNumberofCars(){
        return this.carsForGame.length;
    }

    public int[] getPositionArr(){
        int numberCars = getNumberofCars();
        int[] position_arr = new int[numberCars];
        for(int i=0;i< numberCars; i++){
            position_arr[i] = carsForGame[i].getPosition();
        }
        return position_arr;
    }

    public String[] findWinner(){
        String[] winnerArr = new String[countWinner()];
        int maxPosition = getMax(getPositionArr());
        int i = 0;
        for(Car car : carsForGame) {
            if(car.isWinner(maxPosition)){
                winnerArr[i] = car.getName();
                i++;
            }
        }
        return winnerArr;
    }

    public int countWinner(){
        int count = 0;
        int maxPosition = getMax(getPositionArr());
        for(Car car : carsForGame) {
            if(car.isWinner(maxPosition)){
                count++;
            }
        }
        return count;
    }
}
