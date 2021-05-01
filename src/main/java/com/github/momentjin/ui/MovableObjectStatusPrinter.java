package com.github.momentjin.ui;

import com.github.momentjin.MovableObject;

import java.util.Collection;

public class MovableObjectStatusPrinter {

    private final static String DISPLAY_TEXT_OF_POSITION = "-";


    public void execute(Collection<MovableObject> movableObjects) {

        for (MovableObject movableObject : movableObjects) {
            execute(movableObject);
        }
        System.out.println();
    }

    private void execute(MovableObject movableObject) {

        String status = String.format("%s : %s",
                movableObject.getName().getName(),
                createTextOfMovableLocation(movableObject)
        );

        System.out.println(status);
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
