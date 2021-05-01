package com.github.momentjin.ui;

import com.github.momentjin.Movable;

import java.util.Collection;

public class GameWinnerPrinter {

    private final static String DELIMITER = ", ";

    public void execute(Collection<Movable> movables) {

        if (movables.isEmpty()) {
            throw new IllegalArgumentException("우승자는 최소 1명 이상이어야 합니다");
        }

        String joinedName = join(movables, DELIMITER);
        System.out.println(joinedName+ "가 최종 우승했습니다.");
    }

    private String join(Collection<Movable> movables, String delimiter) {

        StringBuilder joined = new StringBuilder();

        for (Movable movable : movables) {
            joined.append(movable.getName().getName())
                    .append(delimiter);
        }

        return joined.substring(0, joined.lastIndexOf(delimiter));
    }
}
