package app;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Game {

	public ArrayList<Car> list;

	public Game() {
		list = new ArrayList<Car>();
	}

	public void play() {
		int N = input();
		if (N == 0) {
			return;
		}
		run(N);
	}

	public void run(int N) {
		System.out.println("실행 결과");
		for (int i = 0; i < N; i++) {
			playGame();
			printOutCome();
		}
		ArrayList<Car> winCarList = calculateWinner();
		printWinner(winCarList);
	}

	public int input() {
		int N = 0;
		try {
			inputCarName();
			N = inputPlayRound();
		} catch (NullPointerException | NameException e) {
			return 0;
		}
		return N;
	}

	public ArrayList<Car> calculateWinner() {
		int answer = calculateMaximum();
		ArrayList<Car> ret = calculateWinners(answer);
		return ret;
	}

	public ArrayList<Car> calculateWinners(int answer) {
		ArrayList<Car> ret = new ArrayList<Car>();
		for (Car c : list) {
			checkCarIsWinner(answer, c, ret);
		}
		return ret;
	}

	public int calculateMaximum() {
		int answer = 0;
		for (Car c : list) {
			answer = Math.max(answer, c.getPosition());
		}
		return answer;
	}

	public void checkCarIsWinner(int answer, Car c, ArrayList<Car> ret) {
		if (c.getPosition() == answer) {
			ret.add(c);
		}
	}

	public void printWinner(ArrayList<Car> winCarList) {
		for (int i = 0; i < winCarList.size() - 1; i++) {
			System.out.print(winCarList.get(i).getName() + ", ");
		}
		System.out.println(winCarList.get(winCarList.size() - 1).getName() + "가 최종 우승했습니다.");
	}

	public void playGame() {
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

	public int inputPlayRound() {
		System.out.println("시도할 횟수는 몇회인가요?");
		int ret = Reader.getInstance().readInt();
		return ret;
	}

	public void inputCarName() throws NameException, NullPointerException {
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
