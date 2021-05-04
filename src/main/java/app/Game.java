package app;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Game {

	private ArrayList<Car> list;

	public Game() {
		list = new ArrayList<Car>();
	}

	public void play() {
		int N = 0;
		try {
			inputCarName();
			N = inputPlayRound();
		} catch (NullPointerException e) {
			System.out.println("이름의 길이가 너무 짧습니다.");
			return;
		} catch (NameException e) {
			System.out.println(e.toString());
			return;
		} catch (Exception e) {
			System.out.println("에러가 발생했습니다. 다시 진행하세요.");
			return;
		}
		System.out.println("실행 결과");
		for (int i = 0; i < N; i++) {
			playGame();
			printOutCome();
		}
		ArrayList<Car> winCarList = calculateWinner();
		printWinner(winCarList);
	}

	private ArrayList<Car> calculateWinner() {
		int answer = 0;
		for (Car c : list) {
			answer = Calculate(answer, c.getPosition());
		}
		ArrayList<Car> ret = new ArrayList<Car>();
		for (Car c : list) {
			Calculate(answer, c, ret);
		}
		return ret;
	}

	private void Calculate(int answer, Car c, ArrayList<Car> ret) {
		if (c.getPosition() == answer) {
			ret.add(c);
		}
	}

	private int Calculate(int answer, Integer position) {
		return Math.max(answer, position);
	}

	private void printWinner(ArrayList<Car> winCarList) {
		for (int i = 0; i < winCarList.size() - 1; i++) {
			System.out.print(winCarList.get(i).getName() + ", ");
		}
		System.out.println(winCarList.get(winCarList.size() - 1).getName() + "가 최종 우승했습니다.");
	}

	private void playGame() {
		for (Car c : list) {
			c.go();
		}
	}

	private void printOutCome() {
		for (Car car : list) {
			System.out.println(car.toString());
		}
		System.out.println();
	}

	private int inputPlayRound() {
		System.out.println("시도할 횟수는 몇회인가요?");
		int ret = Reader.getInstance().readInt();
		return ret;
	}

	private void inputCarName() throws Exception {
		System.out.println("경주할 자동차 이름을 클릭하세요.(이름은 쉼표(,) 기준으로 구분)");
		String line = Reader.getInstance().readLine();
		StringTokenizer st = new StringTokenizer(line, ",");
		while (st.hasMoreTokens()) {
			Car car = new Car();
			list.add(car);
			car.setName(st.nextToken().trim());
		}
	}

}
