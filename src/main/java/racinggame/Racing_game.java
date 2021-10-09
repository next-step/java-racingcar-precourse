package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Racing_game {
	
	private List<Car> cars = new ArrayList<Car>();
	
	private int cnt;
	
	public Racing_game(String cars) {
		String[] arr=cars.split(",");
		for(String item: arr) {
			Car car=new Car(item);
			this.cars.add(car);
		}		
	}
	
	
	public List<Car> getCars(){
		return cars;
	}
	
	public void setTrycnt(int cnt) {
		this.cnt=cnt;
	}
	
	public int getTrycnt() {
		return cnt;
	}
	
	public Car moving_Car(int idx, int num) {
		Car car=cars.get(idx);
		car.gogo(num);
		cars.set(idx, car);
		return car;
	}

	public int get_distance() {
		int distance=0;
		for(int i=0;i<cars.size();i++) {
			distance=Math.max(distance,cars.get(i).get_distance());
		}
		
		return distance;
		
	}

	public boolean find_winner(int idx) {
		return get_distance()==cars.get(idx).get_distance();
	}
	
	public List<String> get_all_winner(){
		List<String> winner=new ArrayList<>();
		for(int i=0;i<cars.size();i++) {
			winner.add(get_winner(i));
		}
		while(winner.remove(null));
		return winner;
	}
	
	public String get_winner(int idx) {
		return find_winner(idx) ? cars.get(idx).getCar_num():null;
	}

}
