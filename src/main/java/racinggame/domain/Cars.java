package racinggame.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Name : Cars <br/>
 * Description : 레이싱 게임 참가자 클래스
 */
public class Cars {
    public static final int ONE = 1;
    private final List<Car> users;

    public <T> Cars(List<Car> users) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NEED_MORE_USERS.getMessage());
        }
        if (this.hasDupUser(users)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATION_NAME.getMessage());
        }
        this.users = users;
    }

    public Cars() {
        throw new IllegalArgumentException(ErrorCode.NEED_MORE_USERS.getMessage());
    }

    public int getUserCount() {
        return this.users.size();
    }

    public boolean hasDupUser(List<Car> users) {
        for (Car user : users) {
            return checkDupUser(users, user);
        }
        return false;
    }

    private boolean checkDupUser(List<Car> users, Car user) {
        /* Collections.frequency는 내부적으로 equals 메소드로 비교(Car 재정의) */
        return Collections.frequency(users, user) > ONE;
    }

    public List<Car> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int getMaxPosition() {
        return Collections.max(getUsers(), Comparator.comparingInt(Car::getPosition)).getPosition();
    }
}
