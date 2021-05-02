package home.work.racing;

import home.work.racing.wrap.CarMove;
import home.work.racing.wrap.CarName;
import lombok.Getter;

@Getter
public class PlayerCar {
	
	private final CarName name;
	private final CarMove move = new CarMove();
	
	public PlayerCar(CarName name) {
		if (name == null) throw new IllegalArgumentException("�ڵ��� �̸��� ����");
		this.name = name;
	}

	public void moving() {
		this.move.moving();
	}
	
}