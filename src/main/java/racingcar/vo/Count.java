package racingcar.vo;

public class Count {

	private int count;

	public Count(int count) {
		super();
		this.count = count;
	}

	public Count() {
		super();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void up() {
		this.count++;
	}

	public String getNote() {
		String note = "";
		for (int i = 0; i < count; i++) {
			note += "-";
		}
		return note;
	}

}
