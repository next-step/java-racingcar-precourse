package model;

public class Car {

    private int distance;
    private String carName;

    public Car( String carName, int defalutDistance ) {
    	
    	this.carName = carName;
    	this.distance = defalutDistance;
	}
    
	public int getDistance() {
		return distance;
	}

	public String getCarName() {
		return carName;
	}

	public void getTentativeResult(int distance) {
		this.distance += distance;
		String displayArgument = "";
		for( int i = 0; i < this.distance; i++ ){
			displayArgument += "-";
        }
		System.out.println( String.format( "%s : %s" ,this.carName, displayArgument) );
	}

}
