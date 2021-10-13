package racinggame.model;

public class CarDistiance {

	private int distiance;

	public CarDistiance(int position){
		this.distiance = position;
	}

	public int getDistiance(){
		return this.distiance;
	}

	public CarDistiance move(int distiance){
		return new CarDistiance(this.distiance + distiance);
	}
}
