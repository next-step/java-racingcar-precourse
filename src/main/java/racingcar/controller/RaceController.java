package racingcar.controller;

import java.util.Collections;
import java.util.List;

import racingcar.service.RaceService;
import racingcar.vo.Car;
import racingcar.vo.Lane;
import racingcar.vo.Time;

public class RaceController {

	private RaceService service;

	public RaceController() {
		this.service = new RaceService();
	}

	public Lane prepare() {
		Lane lane = new Lane();
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			lane = service.prepare();
		} while (lane.getCars().isEmpty());
		return lane;
	}

	public void play(Lane lane, Time time) {
		for (int i = 0; i < time.getValue(); i++) {
			this.relay(lane);
			this.broadCastProgress(lane);
		}
	}

	private void broadCastProgress(Lane lane) {
		for (Car car : lane.getCars()) {
			System.out.println(car.toString());
		}
		System.out.println();
	}

	private void relay(Lane lane) {
		for (Car car : lane.getCars()) {
			car.go();
		}

	}

	public void award(Lane lane) {
		System.out.print("최종 우승자: ");
		List<Car> winners = this.getWinners(lane);
		for (int i = 0; i < winners.size(); i++) {
			System.out.println(winners.get(i) + (i != winners.size() - 1 ? "," : ""));
		}
	}

	private List<Car> getWinners(Lane lane) {
		int index = this.getWinnersLastIndex(lane);
		return lane.getCars().subList(0, index);
	}

	/**
	 * 어떻게 인덴트가 두 칸 이하가 될 수 있을까? 이건 진짜 모르겠다.
	 * @param lane
	 * @return
	 */
	private int getWinnersLastIndex(Lane lane) {
		List<Car> cars = lane.getCars();
		int max = this.calculateHigh(lane);
		int ret = 1;
		for (ret = 1; ret <= cars.size(); ret++) {
			if (ret == cars.size() || max > cars.get(ret).getCount())
				break;
		}
		return ret;
	}

	private int calculateHigh(Lane lane) {
		Collections.sort(lane.getCars(), (c1, c2) -> Integer.compare(c1.getCount(), c2.getCount()) * -1);
		return lane.getCars().get(0).getCount();
	}

}
