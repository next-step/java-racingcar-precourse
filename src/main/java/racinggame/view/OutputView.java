package racinggame.view;

import nextstep.utils.Randoms;
import racinggame.Car;
import racinggame.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    public static void printRacingGame(RacingGame game){
        for(int i=0 ; i<game.getTryCnt() ;i++){
            run(game);
            System.out.println();

        }
        System.out.printf("최종 우승자는 %s 입니다.",String.join(",",game.getWinners()));
    }

    public static void run(RacingGame game){
        for(int i=0;i<game.getCars().size();i++){
            game.moveCar(i, Randoms.pickNumberInRange(MIN_NUM,MAX_NUM));
            displayCar(game.getCars().get(i));
        }
    }

    public static void displayCar(Car car){
        System.out.print(car.getCarNm() + " : ");
        for(int i=0;i<car.getDistance();i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
