package com.github.momentjin.ui;

import com.github.momentjin.core.model.MovableObject;
import com.github.momentjin.ui.application.MovableObjectStatusService;

import java.util.Collection;

public class MovableObjectStatusPrinter {

    private final MovableObjectStatusService movableObjectStatusService;

    public MovableObjectStatusPrinter(MovableObjectStatusService movableObjectStatusService) {
        this.movableObjectStatusService = movableObjectStatusService;
    }

    public void print(Collection<MovableObject> movableObjects) {
        System.out.println(movableObjectStatusService.createText(movableObjects));
        System.out.println();
    }
}
