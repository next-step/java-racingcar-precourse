package home.work.racing.plural;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import home.work.racing.PlayerCar;

public class PlayerCars {
	
	private final List<PlayerCar> cars = new ArrayList<>();
	
	public void addCar(PlayerCar car) {
		if (car == null) {
			throw new IllegalArgumentException("���� ����");
		}
		this.cars.add(car);
	}
	
	public List<PlayerCar> getCars() {
		return Collections.unmodifiableList(this.cars);
	}

}