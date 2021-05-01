package com.github.momentjin.ui.application;

import com.github.momentjin.core.model.MovableObject;

import java.util.Collection;

public class MovableObjectStatusService {

    private final static String DISPLAY_TEXT_OF_POSITION = "-";

    public String createText(Collection<MovableObject> movableObjects) {

        StringBuilder texts = new StringBuilder();
        for (MovableObject movableObject : movableObjects) {
            texts.append(createTextOne(movableObject)).append("\n");
        }

        return texts.toString().trim();
    }

    private String createTextOne(MovableObject movableObject) {

        return String.format("%s : %s",
                movableObject.getName().getName(),
                createTextOfMovableLocation(movableObject)
        );
    }

    private String createTextOfMovableLocation(MovableObject movableObject) {

        int position = movableObject.getLocation().getPosition();

        StringBuilder textOfPosition = new StringBuilder();
        for (int count = 0; count < position; count++) {
            textOfPosition.append(DISPLAY_TEXT_OF_POSITION);
        }

        return textOfPosition.toString();
    }
}
