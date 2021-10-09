package racinggame.domain;

import racinggame.manage.managing;

public class Car {
	
	private String carName;
	private int distance;
	
	public Car(String carName) {
		this.carName=carName;
	}

	public int Car_distance(){
		return distance;
	}

	

	public void gogo(int n) {
		
		if(managing.isGo(n))
		{
			distance++;
		}
	}


}
