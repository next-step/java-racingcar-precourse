package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.CarName;
import racingcar.domain.car.MyCar;
import racingcar.domain.car.RandomMachine;
import racingcar.domain.car.Round;
import racingcar.domain.car.collect.CarNames;
import racingcar.domain.car.collect.MyCars;
import racingcar.domain.car.collect.Players;

public class CarFacade {

	private final Round round;
	private final RandomMachine randomMachine;
	private final CarNames carNames;
	public CarFacade(Round round, RandomMachine randomMachine, CarNames carNames) {
		this.round = round;
		this.randomMachine = randomMachine;
		this.carNames = carNames;
	}

	public Players playGame() {
		List<MyCars> players = new ArrayList<>();
		for(CarName carName : carNames.getCarNames()){
			players.add(getMyCars(carName));
		}
		return new Players(players);
	}

	private MyCars getMyCars(CarName carName) {
		List<MyCar> myCars = new ArrayList<>();
		for(int i=0;i<round.getRound();i++){
			myCars.add(new MyCar(carName,randomMachine.goAndStop()));
		}
		return new MyCars(myCars);
	}


}
