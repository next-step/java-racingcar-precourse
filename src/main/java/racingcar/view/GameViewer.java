package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;

/**
 * Created by eunbi on 2022/04/18
 */
public class GameViewer {
	/**
	 * 게임 결과를 출력
	 */
	public void printGameResult(List<Car> winnerCar){
	    String winner="";
        for(Car car : winnerCar){
            winner += car.getName()+", ";
        }
        winner = winner.substring(0, winner.length()-2);
        System.out.println("최종 우승자는 " + winner+ " 입니다.");
	}

	/**
	 * 게임 시도 결과를 출력
	 */
	public void printTryResult(List<Car> carList){
		for(Car car : carList){
            System.out.println(car.toString());
		}
	}

	/**
	 * 사용자에게 자동차 이름을 넘겨받는 뷰
	 * @return carName
	 */
	public String inputCarNameList(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carName = Console.readLine();
		return carName;
	}

	/**
	 * 시도횟수를 넘겨받 뷰
	 * @return tryNum
	 */
	public String inputTryNum(){
		System.out.println("시도할 회수는 몇회인가요?");
		String tryNum = Console.readLine();
		return tryNum;
	}

	/**
	 * 게임이 끝난 후 다시 시작할지 여부를 뭍는 뷰
	 * @return isPlayAgin
	 */
	public String getPlayAgain(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String inputNum = Console.readLine();
		return inputNum;
	}

}
