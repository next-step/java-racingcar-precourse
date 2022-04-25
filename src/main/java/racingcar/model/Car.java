package racingcar.model;

public class Car implements Comparable<Car>{
	private Name name;
	private Position position; 
	
	public Car(String name,int position) {
		this.name = new Name(name);
		this.position = new Position(position);
	}
	
	public void move(CarStatus carStatus) {
		position.move(carStatus);
	}

	public String getName() {
		return name.getName();
	}

	public int getPosition() {
		return position.getPosition();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return getPosition()==((Car)obj).getPosition();
	}
	
	@Override
	public int compareTo(Car car) {
		// TODO Auto-generated method stub
		return getPosition()-car.getPosition();
	}
}