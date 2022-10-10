package racingcar.domain.car.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import racingcar.domain.car.CarName;

public class Players {
	private final List<MyCars> players;
	public Players(List<MyCars> players) {
		this.players = new ArrayList<>(players);
	}
	public List<MyCars> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	public Players winnerPlayer() {
		MyCars myCars = Collections.max(players, Comparator.comparingInt(MyCars::lastDistance));
		List<MyCars> winners = filterWinner(myCars);
		return new Players(winners);
	}

	private List<MyCars> filterWinner(MyCars myCars) {
		List<MyCars> winners = new ArrayList<>();
		Consumer<MyCars> isWinner = (a)->{
			if(isEquals(myCars, a)){
				winners.add(a);
			}
		};
		players.forEach(isWinner);
		return winners;
	}

	private boolean isEquals(MyCars a1, MyCars a2) {
		return a1.lastDistance().equals(a2.lastDistance());
	}

	public CarNames playerCarNames(){
		List<CarName> carNames = new ArrayList<>();
		Consumer<MyCars> getCarNames = (a)->{
			carNames.add(a.playerCarName());
		};
		players.forEach(getCarNames);
		return new CarNames(carNames);
	}


	@Override
	public String toString() {
		return "Players{" +
			"players=" + players +
			'}';
	}
}
