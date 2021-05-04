package com.freeefly.util;

import java.util.Scanner;

/**
 * 입력을 받는 클래스
 */
public class InputProcessor {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 개인화된 메시지를 출력하고 입력을 받도록 함
     *
     * @param message
     * @return
     */
    public static String putNumbers(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}