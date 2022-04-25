package study.lottoGame;

import java.util.*;

public class LottoNumber {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static String OUT_OF_RANGE = "로또번호는 1~45의 범위입니다.";
    private final static Map<Integer, LottoNumber> NUMBERS = new HashMap<>();

    private int lottoNumber;

    static {
        for(int i=MIN_LOTTO_NUMBER; i<MIN_LOTTO_NUMBER +1;i++){
            NUMBERS.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number){
        LottoNumber lottoNumber = NUMBERS.get(number);
        if(lottoNumber == null){
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        return lottoNumber;
    }
    //...
}
