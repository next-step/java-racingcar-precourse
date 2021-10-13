package racinggame;

public class Car implements Comparable<Car> {
	public static final String NO_NAME = "[ERROR]자동차 이름이 존재하지 않습니다.";
	public static final String LONG_NAME = "[ERROR]자동차 이름은 5자리 이하 입니다.";
	private String name;
	private int step;
	
	public Car(String name) {
		if (StringUtil.isEmpty(name)) {
			System.out.println(Car.NO_NAME);
			throw new IllegalArgumentException();
		}
		if (name.length() > 5) {
			System.out.println(Car.LONG_NAME);
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.step = 0;
	}
	
	public void go() {
		this.step++;
	}
	
	public void showStatus() {
		System.out.println(name + " : " + getHipen());
	}
	
	private String getHipen() {
		StringBuffer sb = new StringBuffer(this.step);
		for (int i = 0; i < this.step; i++) {
			sb.append('-');
		}
		return sb.toString();
	}
	
	public boolean isWinner(int winnerStep) {
		return this.step == winnerStep;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getStep() {
		return this.step;
	}

	@Override
	public int compareTo(Car car) {
		return car.getStep() - this.getStep(); 
	}
}
