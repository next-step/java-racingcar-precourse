package study.lottoGame;

import java.util.*;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers){
        validateDuplication(lottoNumbers);
        validateAmountOfNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateAmountOfNumbers(List<LottoNumber> lottoNumbers) {
    }

    private void validateDuplication(List<LottoNumber> lottoNumbers) {
    }
}
