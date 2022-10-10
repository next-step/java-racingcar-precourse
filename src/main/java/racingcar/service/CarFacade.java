package racingcar.service;

import static racingcar.constant.COMMENT.*;
import static racingcar.constant.COMMON_LETTER.*;

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

	public void playGame() {
		List<MyCars> players = new ArrayList<>();
		for(CarName carName : carNames.getCarNames()){
			players.add(getMyCars(carName));
		}
		resultGame(new Players(players));
	}

	private MyCars getMyCars(CarName carName) {
		List<MyCar> myCars = new ArrayList<>();
		for(int i=0;i<round.getRound();i++){
			myCars.add(new MyCar(carName,randomMachine.goAndStop()));
		}
		return new MyCars(myCars);
	}
	private void resultGame(Players players){
		System.out.print(PLAY_RESULT);
		for(int roundIndex=0;roundIndex<round.getRound();roundIndex++){
			gameResultOutPut(players,roundIndex);
		}
		System.out.print(WINNER);
		Players winners = players.winnerPlayer();
		winnerResultOutPut(winners);
	}

	private void gameResultOutPut(Players players, int roundIndex) {
		for (MyCars myCars : players.getPlayers()) {
			resultOutByPlayer(roundIndex, myCars);
		}
		System.out.println();
	}

	private void resultOutByPlayer(int roundIndex, MyCars myCars) {
		MyCar myCar = myCars.myCarsByRound(roundIndex);

		outCarName(myCar.getName()+ COLON);
		outCountToBar(myCars.currentDistance(roundIndex));
	}

	private void winnerResultOutPut(Players winners) {
		CarNames winnerCarNames = winners.playerCarNames();
		System.out.print(winnerCarNames.join(COMMA));
	}

	private void outCarName(String name){
		System.out.print(name);
	}

	private void outCountToBar(int count){
		for(int i = 0;i<count;i++){
			System.out.print(BAR);
		}
		System.out.println();
	}

}
