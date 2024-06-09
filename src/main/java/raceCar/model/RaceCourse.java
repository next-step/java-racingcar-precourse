package raceCar.model;

import java.util.Map;

public class RaceCourse {
	private final Map<Car,Integer> track;

	public Map<Car, Integer> getTrack() {
		return track;
	}

	// 차량 등록
	public void addCar(Car car) {
		track.put(car, 0);
	}

	private RaceCourse(Map<Car,Integer> track) {
		this.track = track;
	}

	public static RaceCourse of(Map<Car,Integer> track) {
		return new RaceCourse(track);
	}
}
