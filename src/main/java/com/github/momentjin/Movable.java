package com.github.momentjin;


import com.github.momentjin.car.CarName;

public interface Movable {

    CarName getName();
    void moveForward();
    Location getLocation();
}
