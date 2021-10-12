package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageBuilderTest {

    @DisplayName("메세지 append 정상적으로 더해지는지 테스트")
    @Test
    void append_success() {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.append(new Message("test1"));
        messageBuilder.append(new Message("test2"));

        assertThat(messageBuilder.toMessage()).isEqualTo(new Message("test1test2"));
    }

    @DisplayName("메세지 개행 정상적으로 더해지는지 테스트")
    @Test
    void appendNewLine_success() {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.appendNewLine();

        assertThat(messageBuilder.toMessage()).isEqualTo(new Message("\n"));
    }

    @DisplayName("메세지로 제대로 변환되는지 테스트")
    @Test
    void toMessage_success() {
        MessageBuilder messageBuilder = new MessageBuilder(new Message("test"));

        assertThat(messageBuilder.toMessage()).isEqualTo(new Message("test"));
    }
}