package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {

	ArrayList<Car> list;
	Integer N;
	Scanner sc;
	
	public Game() {
		list = new ArrayList<Car>();
		N = 0;
		sc = new Scanner(System.in);
	}
	
	public void play() {
		inputCarName();
		inputPlayRound();
		printOutCome();
	}

	private void printOutCome() {
		System.out.println("실행 결과");
		for(Car car : list) {
			car.toString();
		}
	}

	private void inputPlayRound() {
		System.out.println("시도할 횟수는 몇회인가요?");
		N = sc.nextInt();
	}

	private void inputCarName() {
		System.out.println("경주할 자동차 이름을 클릭하세요.(이름은 쉼표(,) 기준으로 구분)");
		String line = sc.nextLine();
		StringTokenizer st = new StringTokenizer(line, ",");
		while(st.hasMoreTokens()) {
			Car car = new Car(st.nextToken());
			list.add(car);
		}	
	}

}
