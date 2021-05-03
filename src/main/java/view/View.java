package view;

import java.util.List;

import model.Car;

public class View {
	public void outputInputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void outputInputTryCount() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public void outputExecutionResult() {
		System.out.println("\n실행 결과");
	}

	public void outputExecutionResultDetail(List<Car> carList) {
		if (carList == null) {
			return;
		}
		for (int i = 0; i < carList.size(); i++) {
			System.out.print(carList.get(i).getName() + " : ");
			outputDashAsNum(carList.get(i).getPosition());
		}
		System.out.println();
	}

	private void outputDashAsNum(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void outputWinner(List<Car> winnerList) {
		if (winnerList == null) {
			return;
		}
		for (int i = 0; i < winnerList.size(); i++) {
			System.out.print(winnerList.get(i).getName());
			if (i != winnerList.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("가 최종 우승했습니다.");
	}
}
