package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarGame;
import racingcar.view.GameViewer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunbi on 2022/04/18
 */
public class GameController {
    private CarGame carGame = new CarGame();
    private GameViewer gameViewer = new GameViewer();
    private GameValidator gameValidator = new GameValidator();

    // 게임을 시작하지.
    public void startGame(){
        try {
            // 1. INIT
            //  1-1. 차 이름을 입력받는다
            //  1-2. try횟수를 입력받는다
            initGame();
            // 2. Try횟수만큼 시도한다.
            //  2-1. 이동
            //  2-2. 이동 출력
            doGame();

            // 3. 최종
            //  3-1. 우승자 선별
            //  3-2. 우승자 출력
            resultGame();
        }catch (Exception e){

        }
    }


    // 게임 초기화
    //  1-1. 차 이름을 입력받는다
    //  1-2. try횟수를 입력받는다
    public void initGame() throws Exception{
        carGame = new CarGame();
        carGame.setCarList(getCarList());
        carGame.setTryNum(getTryNum());
    }

    private ArrayList<Car> getCarList(){
        String carInputList = gameViewer.inputCarNameList();
        String[] carListSpl = carInputList.split(",");
        if(carListSpl.length < 1){
        }
        ArrayList<Car> carList = new ArrayList<>();
        for (String car : carListSpl){
            gameValidator.checkNameLength(car);
            carList.add(new Car(car));
        }
        return carList;
    }

    private int getTryNum(){
        String tryNumStr = gameViewer.inputTryNum();
        return Integer.parseInt(tryNumStr);
    }


    // 2. Try횟수만큼 시도한다.
    //  2-1. 이동
    //  2-2. 이동 출력
    private void doGame(){
        for(int i=0; i< carGame.getTryNum(); i++){
            moveRandom();
            gameViewer.printTryResult(carGame.getCarList());
            System.out.println();
        }
    }
    private void moveRandom() {
        for (Car car : carGame.getCarList()) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            car.addMove(gameValidator.checkMoveNum(randomNum) ? 1 : 0);
        }
    }

    private void resultGame(){
        int maxNum =0;
        ArrayList<Car> resultList = new ArrayList<>();
        for(Car car : carGame.getCarList()){
            if(maxNum == car.getMove()){
                resultList.add(car);
            }
            if(maxNum < car.getMove()){
                resultList.clear();
                resultList.add(car);
                maxNum = car.getMove();
            }
        }
        gameViewer.printGameResult(resultList);
    }



}
