package com.github.momentjin.mock;

import com.github.momentjin.core.model.Location;

public class MockLocation implements Location {

    private final int position;

    public MockLocation(int position) {
        this.position = position;
    }

    @Override
    public Location increaseOne() {
        return new MockLocation(position + 1);
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Location o) {
        return Integer.compare(position, o.getPosition());
    }
}
