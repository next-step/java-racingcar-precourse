package controller;

import java.util.List;

import model.Car;
import model.Cars;
import view.View;
import util.GameUtil;

public class Controller {
	private Cars cars;
	private View view;

	public Controller(Cars cars, View view) {
		this.cars = cars;
		this.view = view;
	}

	public void updateEachCar() {
		for (int j = 0; j < cars.getCarList().size(); j++) {
			Car car = cars.getCarList().get(j);
			int randomNum = GameUtil.generateRandomNum();
			if (GameUtil.isMovable(randomNum)) {
				car.forward();
			}
		}
	}

	public void delayGame() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void proceedEachTurn(int tryCount) {
		view.outputExecutionResult();
		for (int i = 0; i < tryCount; i++) {
			updateEachCar();
			view.outputExecutionResultDetail(cars.getCarList());
			delayGame();
		}
		List<Car> winners = GameUtil.getFirstPositionCarList(cars.getCarList());
		view.outputWinner(winners);
	}
}
