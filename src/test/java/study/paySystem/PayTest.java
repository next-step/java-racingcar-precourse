package study.paySystem;

import org.junit.jupiter.api.Test;
import study.paySystem.KakaoPays;
import study.paySystem.NaverPays;
import study.paySystem.Pay;
import study.paySystem.PayGroups;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static study.paySystem.PayType.*;

public class PayTest {
    @Test
    public void 로직이_밖에_있는_상태(){
        //값은 여기 있는데
        List<Pay> pays = Arrays.asList(
                new Pay(NAVER_PAY, 1000),
                new Pay(NAVER_PAY, 1500),
                new Pay(KAKAO_PAY, 2000),
                new Pay(TOSS, 3000L)
        );

        //상태와 로직이 한곳에!
        PayGroups payGroups = new PayGroups(pays);
        Long naverPaySum = payGroups.getNaverPaySum();

        assertThat(naverPaySum).isEqualTo(2500);
    }

    @Test
    public void 컬렉션을_변수명으로(){
        List<Pay> naverPays = createNaverPays();
        List<Pay> kakakoPays = createKakaoPays();
    }

    @Test
    public void 일급컬렉션의_이름으로(){
        NaverPays naverpays = new NaverPays(createNaverPays());
        KakaoPays kakaopays = new KakaoPays(createKakaoPays());
    }

    private List<Pay> createKakaoPays() {
        return Arrays.asList(
                new Pay(KAKAO_PAY, 2000)
        );
    }

    private List<Pay> createNaverPays() {
        return Arrays.asList(
                new Pay(NAVER_PAY, 1000),
                new Pay(NAVER_PAY, 1500)
        );
    }
}
