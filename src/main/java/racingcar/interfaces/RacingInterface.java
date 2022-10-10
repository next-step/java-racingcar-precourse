package racingcar.interfaces;

import static racingcar.constant.COMMENT.*;
import static racingcar.constant.COMMON_LETTER.*;
import static racingcar.constant.ERROR.*;
import static racingcar.constant.SETTING.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.CarName;
import racingcar.domain.car.RandomMachine;
import racingcar.domain.car.Round;
import racingcar.domain.car.collect.CarNames;
import racingcar.service.CarFacade;
import racingcar.util.TextOutPut;

public class RacingInterface {
	private Process process;
	private boolean isAlive;
	private Round round;
	private RandomMachine randomMachine;
	private CarNames carNames;
	private TextOutPut textOutPut;

	public boolean isAlive() {
		return isAlive;
	}
	public interface Process{
		Process run(String input);
	}

	public RacingInterface(){
		gameInit();
		process = inputNames();
		//baseBallResultOutput = new BaseBallResultOutput();
	}

	public void processRun(){
		String input = Console.readLine();
		process = process.run(input);
	}

	private void gameInit(){
		textOutPut = new TextOutPut(INPUT_NAME_MESSAGE);
		randomMachine = new RandomMachine(START_RANGE,END_RANGE);
		isAlive = true;
	}
	private Process inputNames(){
		return input->{
			List<CarName> carNames = new ArrayList<>();
			for(String name:multiNameToList(input)){
				carNames.add(CarName.of(name));
			}
			this.carNames = new CarNames(carNames);
			return inputRound();
		};
	}

	private Process inputRound(){
		printLines(INPUT_ROUND_MESSAGE);
		return input->{
			round = Round.stringOf(input);
			return gamePlay();
		};
	}

	private Process gamePlay(){
		CarFacade carFacade = new CarFacade(round,randomMachine,carNames);
		carFacade.playGame();
		isAlive = false;
		return input-> null;
	}


	private List<String> multiNameToList(String input) {
		if(input.isEmpty()){
			throw new IllegalArgumentException(EMPTY_NAME);
		}

		return Arrays.asList(input.split(COMMA));
	}

	public String flushOutPut() {
		return textOutPut.flush();
	}
	public void printLines(String text){
		textOutPut.printLines(text);
	}
}
