package racinggame.domain;

import java.util.List;
import java.util.Objects;

import racinggame.utils.Message;
import racinggame.utils.MessageBuilder;

public class Winners {
    private List<Name> winners;

    public Winners(List<Name> winners) {
        this.winners = winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Winners)) {
            return false;
        }
        Winners winners1 = (Winners)o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }

    public Message makeWinnersMessage() {
        MessageBuilder messageBuilder = new MessageBuilder(new Message("최종 우승자는 "));
        for (int idx = 0; idx < winners.size(); idx++) {
            messageBuilder.append(messageWithCommaIfNotLastElement(idx, winners.get(idx)));
        }

        return messageBuilder.append(new Message(" 입니다.")).toMessage();
    }

    private Message messageWithCommaIfNotLastElement(int idx, Name name) {
        if (idx == winners.size() - 1) {
            return name.makeNameMessage();
        }

        return new MessageBuilder().append(name.makeNameMessage()).append(Message.COMMA).toMessage();
    }

}
