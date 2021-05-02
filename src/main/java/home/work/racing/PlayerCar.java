package home.work.racing;

import home.work.racing.wrap.CarName;
import lombok.Getter;

@Getter
public class PlayerCar {
	
	private final CarName name;
	
	public PlayerCar(CarName name) {
		if (name == null) throw new IllegalArgumentException("�ڵ��� �̸��� ����");
		this.name = name;
	}
	
}