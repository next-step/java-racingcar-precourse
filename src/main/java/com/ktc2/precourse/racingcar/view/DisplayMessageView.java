package com.ktc2.precourse.racingcar.view;

/**
 * 표준 출력으로 String을 출력한다.
 */
public class DisplayMessageView implements DisplayView<String> {

    @Override
    public void display(String data) {
        System.out.println(data);
    }
}
