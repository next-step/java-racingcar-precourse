/*
 * GameManagerTest
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-09.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import nextstep.utils.Console;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    @Test
    public void 자동차_이름_입력() throws Exception {
        String input = "";
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            input = Console.readLine();
        } while (GameManager.isValidateInputCarName(input));
    }

    @Test
    public void 시도횟수_입력() throws Exception {
        String input = "";
        do {
            System.out.println("시도할회수는몇회인가요?");
            input = Console.readLine();
        } while (GameManager.isValidateInputTryCount(input));
    }
}
