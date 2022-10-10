package racingcar.view.port.outbound;

import javax.naming.OperationNotSupportedException;

public class StandardOutput {

    public static final String ERROR = "[ERROR] ";

    private StandardOutput() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("인스턴스를 만들 수 없습니다.");
    }

    public static void println(final Object message) {
        System.out.println(message);
    }

    public static void Error(final Object message) {
        System.out.print(ERROR + message);
    }

    public static void println() {
        System.out.println();
    }
}
