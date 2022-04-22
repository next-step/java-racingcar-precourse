package racingcar;

import camp.nextstep.edu.missionutils.Console;
import firstClass.Cars;
import primitiveWrapperClass.TryCount;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main( String[] args ) {
        initGame();
    }

    public static void initGame(){
        List<Car> carList = new ArrayList<>();
        boolean notYetMakedCars = true;
        while(notYetMakedCars){
            notYetMakedCars = makedCar( carList );
        }
        Cars cars = new Cars( carList );

        TryCount tryCount = null;
        while(tryCount == null){
            tryCount = validCount();
        }

        gameStart( cars, tryCount );
    }

    public static boolean makedCar( List<Car> carList ){
        carList.clear();
        boolean notYetMakedCars = false;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesArray = Console.readLine().split( "," );
        for(int i = 0 ; i < carNamesArray.length; i ++){
            notYetMakedCars = setEachCar( carNamesArray[i], carList ) ? notYetMakedCars : true ;
        }

        return notYetMakedCars;
    }

    private static boolean setEachCar(String carName, List<Car> carList){
        boolean isSet = true;
        try{
            Car car = new Car( carName, "" );
            carList.add( car );
        }catch(IllegalArgumentException | IllegalStateException e){
            isSet = false;
            System.out.println(e.getMessage());
        }finally {
            return isSet;
        }
    }

    private static TryCount validCount(){
        TryCount tryCount = null;
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            tryCount = new TryCount( Console.readLine() );
        } catch (IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return tryCount;
        }
    }

    public static void gameStart(Cars cars, TryCount tryCount){
        System.out.println("실행 결과");
        Game game = new Game(cars);
        game.startCarRacing(tryCount.showGameTryCount());
    }
}
