package racinggame.domain;

import static racinggame.common.CommonConstants.*;
import static racinggame.common.ErrorMessage.*;

/**
 * 입력 횟수 제한을 위한 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class InputCount {
	public int count;

	public InputCount() {
		count = 0;
	}

	public int getCount() {
		return count;
	}

	/**
	 * 입력횟수 추가
	 *
	 * @throws IllegalStateException 최대 입력횟수 초과시 발생
	 */
	public void plus() {
		if (!isPossible()) {
			throw new IllegalStateException(ERROR_TO_MANY_INPUT);
		}
		count++;
	}

	/**
	 * 더 이상 입력이 가능 한지 확인
	 *
	 * @return 추가 입력 가능 여부
	 */
	public boolean isPossible() {
		return count + 1 <= MAX_INPUT_COUNT;
	}
}
