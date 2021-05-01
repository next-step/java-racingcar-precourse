package com.github.momentjin.core.application;

import com.github.momentjin.core.model.Location;
import com.github.momentjin.core.model.MovableObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxPositionExtractionService {

    private final static Comparator<MovableObject> MAX_LOCATION_COMPARATOR
            = Comparator.comparing(MovableObject::getLocation).reversed();

    public List<MovableObject> extract(List<MovableObject> movableObjects) {

        if (movableObjects.isEmpty()) {
            throw new IllegalArgumentException("비어있는 리스트는 허용하지 않습니다");
        }

        Location maxLocation = getMaxLocation(movableObjects);
        return filterMovablesByLocation(movableObjects, maxLocation);
    }

    private Location getMaxLocation(List<MovableObject> movableObjects) {
        movableObjects.sort(MAX_LOCATION_COMPARATOR);
        return movableObjects.get(0).getLocation();
    }

    private List<MovableObject> filterMovablesByLocation(List<MovableObject> movableObjects, Location location ) {

        List<MovableObject> maxLocationMovableObjects = new ArrayList<>();
        for (MovableObject movableObject : movableObjects) {
            if (movableObject.getLocation().equals(location)) {
                maxLocationMovableObjects.add(movableObject);
            }
        }

        return maxLocationMovableObjects;
    }
}

