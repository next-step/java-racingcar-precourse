package racinggame.domain;

import static racinggame.common.CommonConstants.*;

/**
 * 이동거리 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Distance {
	private int distance;

	public Distance() {
		this.distance = 0;
	}

	/**
	 * 자동차의 이동거리 추가
	 */
	public void plus() {
		distance++;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			result.append(DISTANCE_STR);
		}
		return result.toString();
	}
}
