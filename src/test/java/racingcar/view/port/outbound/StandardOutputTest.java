package racingcar.view.port.outbound;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Constructor;
import javax.naming.OperationNotSupportedException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StandardOutputTest {
    @Test
    @DisplayName("StandardOutput Instance 를 만들지 못하는지 확인")
    void instance_new_test() {
        Class<StandardOutput> standardOutputClass = StandardOutput.class;
        Constructor<?>[] declaredConstructors = standardOutputClass.getDeclaredConstructors();

        Assertions.assertThat(declaredConstructors).hasSize(1);

        Constructor<?> declaredConstructor = declaredConstructors[0];
        declaredConstructor.setAccessible(true);
        Assertions.assertThat(declaredConstructor.getParameterCount()).isEqualTo(0);

        assertThatThrownBy(declaredConstructor::newInstance)
                .hasCauseInstanceOf(OperationNotSupportedException.class)
                .hasStackTraceContaining("인스턴스를 만들 수 없습니다.");
    }
}