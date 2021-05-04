package app;

import java.util.Random;

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

	public Car() {
		this.name = null;
		this.position = 0;
		this.isWin = false;
	}

	public void go() {
		Random rand = new Random();   
	    // Generate random integers in range 0 to 9   
	    int r = rand.nextInt(10);     
		if(r >= 4) {
			this.position += 1;			
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws NameException, NullPointerException {
		
		if(name == null || name.length() ==0 ) {
			throw new NullPointerException();
		}
		if(name.length() > 5) {
			throw new NameException("이름이 너무 깁니다.");
		}
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
