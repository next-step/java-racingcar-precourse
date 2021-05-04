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
		try {
			inputCarName();
			inputPlayRound();			
		}catch (NullPointerException e) {
			System.out.println("이름의 길이가 너무 짧습니다.");
			return;
		}catch (NameException e) {
			System.out.println(e.toString());
			return;
		}catch (Exception e) {
			System.out.println("에러가 발생했습니다. 다시 진행하세요.");
			return;
		}
		System.out.println("실행 결과");
		for(int i = 0 ; i < N ; i++) {
			playGame();
			printOutCome();
		}
	}

	private void playGame() {
		for(Car c : list) {
			c.play();
		}
	}

	private void printOutCome() {
		for(Car car : list) {
			car.toString();
		}
	}

	private void inputPlayRound() {
		System.out.println("시도할 횟수는 몇회인가요?");
		N = sc.nextInt();
	}

	private void inputCarName() throws Exception {
		System.out.println("경주할 자동차 이름을 클릭하세요.(이름은 쉼표(,) 기준으로 구분)");
		String line = sc.nextLine();
		StringTokenizer st = new StringTokenizer(line, ",");
		while(st.hasMoreTokens()) {
			Car car = new Car();
			list.add(car);
		}	
	}

}
