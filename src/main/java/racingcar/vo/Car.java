package racingcar.vo;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	Name name;
	Count count;

	public Car(String name) {
		super();
		this.name = new Name(name);
		this.count = new Count(0);
	}

	public Car(String name, int count) {
		super();
		this.name = new Name(name);
		this.count = new Count(count);
	}

	public String getName() {
		return this.name.getValue();
	}

	public void setName(String name) {
		this.name = new Name(name);
	}

	public int getCount() {
		return this.count.getCount();
	}

	@Override
	public String toString() {
		return this.name.getValue() + " : " + this.count.getNote();
	}

	public void setCount(int count) {
		this.count = new Count(count);
	}

	public void go() {
		if (Randoms.pickNumberInRange(0, 10) >= 4) {
			this.count.up();
		}

	}

}
