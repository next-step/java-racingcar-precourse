package com.github.momentjin;

public interface Location extends Comparable<Location> {
    
    Location increaseOne();
    int getPosition();
}