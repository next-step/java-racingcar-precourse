package racingcar.controller.message.printer;

import racingcar.view.Message;

public class MessagePrinter {
    public static void print(Message message) {
        System.out.print(message.getValue());
    }

    public static void println(Message message) {
        System.out.println(message.getValue());
    }
}
