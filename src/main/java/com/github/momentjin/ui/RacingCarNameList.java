package com.github.momentjin.ui;

import java.util.Iterator;
import java.util.List;

public class RacingCarNameList {

    private final List<String> carNames;

    public RacingCarNameList(List<String> carNames) {
        this.carNames = carNames;
    }

    public Iterator<String> iterator() {
        return this.carNames.iterator();
    }

    public String get(int index) {
        return this.carNames.get(index);
    }

    public int size() {
        return this.carNames.size();
    }
}