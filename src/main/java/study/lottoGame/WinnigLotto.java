package study.lottoGame;

public class WinnigLotto {
    //...
    private static final String BONUS_CANNOT_BE_DUPLICATE_WITH_WINNING_NUMBER =
            "보너스 넘버는 위닝 넘버와 중복될 수 없습니다.";

    private Lotto winningLottoNumbers;
    private LottoNumber bonusNumbers;

    public WinnigLotto(Lotto winningLottoNumbers, LottoNumber bonusNumbers){
        this.winningLottoNumbers = winningLottoNumbers;
        if(isBonusNumberDuplicatedWithWinningNumber(winningLottoNumbers, bonusNumbers)){
            throw new IllegalArgumentException(BONUS_CANNOT_BE_DUPLICATE_WITH_WINNING_NUMBER);
        }
        this.bonusNumbers = bonusNumbers;
    }

    private boolean isBonusNumberDuplicatedWithWinningNumber(Lotto winningLottoNumbers, LottoNumber bonusNumbers) {
        return true;
    }
    //...
}
