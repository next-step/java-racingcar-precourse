package app;

public class Car {

	private String name;
	private Integer position;
	private boolean isWin;

	public Car(String name, int position, boolean isWin) {
		super();
		this.name = name;
		this.position = position;
		this.isWin = isWin;
	}

	public Car(String name) {
		super();
		this.name = name;
		this.position = 0;
		this.isWin = false;
	}

	public void go() {
		this.position += 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		return name + " : " + sb.toString();
	}

}
