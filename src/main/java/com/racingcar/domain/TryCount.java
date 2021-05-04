package com.racingcar.domain;

public class TryCount {

    private final Integer tryCount;

    private TryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }

    public Boolean isFinish() {
        return tryCount == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public TryCount consumeTryCount() {
        return new TryCount(this.tryCount - 1);
    }

    public static TryCount of(Integer tryCount) {
        return new TryCount(tryCount);
    }
}
