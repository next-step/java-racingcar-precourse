import java.util.List;

import car.Cars;

public class RunCarGame {

	public static void main(String[] args) {

		UserInterface userInterface = new UserInterface();
		GenerateMovePoint generateMovePoint = new GenerateMovePoint();

		try {
			String carNames = userInterface.readAndInputValue("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
			int raceCount = Integer.parseInt(userInterface.readAndInputValue("시도할 회수는 몇 회 인가요?"));
			Cars cars = null;
			if (!"".equals(carNames)) {
				cars = new Cars(carNames);
			}

			if (cars == null) {
				throw new Exception("자동차 생성에 문제가 발생 하였습니다.");
			}
			for (int i = 0; i < raceCount; i++) {
				List<Integer> movePoints = generateMovePoint.makeMovePointList(cars.getCarCount());
				cars.race(movePoints);
				cars.showCarsIndex();
			}

			String winners = cars.reportRace();

			if (!"".equals(winners)) {
				System.out.println(winners + "가 최종 우승 했습니다.");
			}

			if ("".equals(winners)) {
				System.out.println("한대도 움직이지 않았습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
