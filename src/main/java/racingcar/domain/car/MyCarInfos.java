package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCarInfos {

	private final List<MyCarInfo> myCarInfos;

	public MyCarInfos(List<MyCarInfo> myCarInfos) {
		this.myCarInfos = new ArrayList(myCarInfos);
	}

	public List<MyCarInfo> getMyCarInfos() {
		return Collections.unmodifiableList(myCarInfos);
	}
}
