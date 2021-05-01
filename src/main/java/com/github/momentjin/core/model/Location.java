package com.github.momentjin.core.model;

public interface Location extends Comparable<Location> {
    
    Location increaseOne();
    int getPosition();
}