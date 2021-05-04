package domain;

import domain.strategy.MovableStrategy;

public class Moving {
    private MovableStrategy movableStrategy;

    public void move(int num) {
        movableStrategy.move(num);
    }

    public void setMovableStrategy(MovableStrategy movableStrategy){
        this.movableStrategy = movableStrategy;
    }


    public int getPos() {
        return this.movableStrategy.getPos();
    }
}