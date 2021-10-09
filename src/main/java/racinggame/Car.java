package racinggame;

import racinggame.manage.managing;

public class Car {
	private String carNum;
	private int distance=0;
	
	public Car(String car_num) {
		this.carNum=car_num;
	}
	
	public int get_distance() {
		return distance;
	}
	
	public void gogo(int n) {
		
		if(managing.isGo(n)) {
			distance++;
		}
	}
	
	public String getCar_num() {
		return this.carNum;
	}



}
