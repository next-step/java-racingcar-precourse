package com.ktc2.precourse.racingcar.view;

/**
 * 표준 출력(System.out)으로 프로그램 정보를 출력하는 뷰
 *
 * @param <D> 표준 출력으로 출력하고자 하는 타입
 */
public interface DisplayView<D> {

    /**
     * data를 표준 출력으로 출력한다.
     *
     * @param data 출력할 정보
     */
    void display(D data);
}
