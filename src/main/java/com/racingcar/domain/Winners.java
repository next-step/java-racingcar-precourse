package com.racingcar.domain;

import java.util.Iterator;
import java.util.List;

public class Winners implements Iterable<Winner> {

    private final List<Winner> winners;

    private Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public int length() {
        return winners.size();
    }

    public static Winners of(List<Winner> winners) {
        return new Winners(winners);
    }

    @Override
    public Iterator<Winner> iterator() {
        return winners.iterator();
    }
}
