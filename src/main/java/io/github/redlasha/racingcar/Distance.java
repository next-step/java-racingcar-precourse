package io.github.redlasha.racingcar;

public class Distance implements Comparable<Distance> {

	private static final String PRINT_UNIT = "-"; 
	
	private int distance;

	public Distance() {

	}

	Distance(int distance) {
		this.distance = distance;
	}

	public void add() {
		this.distance++;
	}

	public Integer get() {
		return Integer.valueOf(this.distance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (distance != ((Distance)obj).distance) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Distance o) {
		return get().compareTo(o.get());
	}

	public String stringValue() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			builder.append(PRINT_UNIT);
		}
		return builder.toString();
	}
	
	

}
