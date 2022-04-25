package study.paySystem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Pay {

    private String payType;
    private Number amount;

    public Pay(String payType, Number amount) {
        this.payType = payType;
        this.amount = amount;
    }

    public Long getAmount() {
        return Long.parseLong(String.valueOf(amount));
    }

    public String getPayType() {
        return payType;
    }
}
