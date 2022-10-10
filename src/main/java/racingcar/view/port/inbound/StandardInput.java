package racingcar.view.port.inbound;

import camp.nextstep.edu.missionutils.Console;
import javax.naming.OperationNotSupportedException;

public class StandardInput {
    private StandardInput() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("인스턴스를 만들 수 없습니다.");
    }

    public static String readLine() {
        return Console.readLine();
    }
}
