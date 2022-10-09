package racingcar.domain.car;

import java.util.*;
import java.util.function.Consumer;

public class CarNames implements Iterable<String> {

    private static final String ERROR_TYPE = "[ERROR] 자동차 이름은 한글이나 영어만 가능합니다.";
    private static final String ERROR_LENGTH = "[ERROR] 자동차 이름은 공백일 수 없습니다.";
    private static final String ERROR_DUPLICATION = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    private final List<String> names;

    public CarNames() {
        this.names = new ArrayList<>();
    }

    public CarNames(String str) {
        this.names = Arrays.asList(str.split(","));
        this.invalid();
    }

    private void invalid() {
        for (String name : names) {
            invalidName(name);
        }
        if (invalidDuplication()) {
            throw new IllegalArgumentException(ERROR_DUPLICATION);
        }
    }

    private void invalidName(String name) {
        if (invalidType(name)) {
            throw new IllegalArgumentException(ERROR_TYPE);
        }
        if (invalidLength(name)) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    private boolean invalidType(String name) {
        return !name.replaceAll("[^a-zA-Z가-힣]", "").equals(name);
    }

    private boolean invalidLength(String name) {
        return name.length() < 1;
    }

    private boolean invalidDuplication() {
        Set<String> hashSet = new HashSet<>(this.names);
        return hashSet.size() != this.names.size();
    }

    @Override
    public Iterator<String> iterator() {
        return this.names.iterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        this.names.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return this.names.spliterator();
    }

    public void add(String name) {
        this.names.add(name);
    }
}
