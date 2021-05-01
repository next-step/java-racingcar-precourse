package com.github.momentjin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxPositionExtractor {

    private final static Comparator<Movable> MAX_LOCATION_COMPARATOR
            = Comparator.comparing(Movable::getLocation).reversed();

    public List<Movable> extract(List<Movable> movables) {

        if (movables.isEmpty()) {
            throw new IllegalArgumentException("비어있는 리스트는 허용하지 않습니다");
        }

        Location maxLocation = getMaxLocation(movables);
        return filterMovablesByLocation(movables, maxLocation);
    }

    private Location getMaxLocation(List<Movable> movables) {
        movables.sort(MAX_LOCATION_COMPARATOR);
        return movables.get(0).getLocation();
    }

    private List<Movable> filterMovablesByLocation(List<Movable> movables, Location location ) {

        List<Movable> maxLocationMovables = new ArrayList<>();
        for (Movable movable : movables) {
            if (movable.getLocation().equals(location)) {
                maxLocationMovables.add(movable);
            }
        }

        return maxLocationMovables;
    }
}

