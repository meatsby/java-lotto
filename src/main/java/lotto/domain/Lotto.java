package lotto.domain;

import java.util.Objects;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;

public class Lotto {
    private static final String EMPTY_INPUT_MSG = "로또 번호가 입력되지 않았습니다.";
    private static final String INVALIDATE_LOTTO_NUMBERS_ERROR_MSG = "로또 번호는 중복되지 않는 6개의 숫자여야 합니다.";
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validateNotNull(lottoNumbers);
        validateDistinctNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this(new TreeSet<>(lottoNumbers));
    }

    private void validateNotNull(Set<LottoNumber> lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, EMPTY_INPUT_MSG);
    }

    private void validateDistinctNumbers(Set<LottoNumber> inputNumbers) {
        if (inputNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALIDATE_LOTTO_NUMBERS_ERROR_MSG);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean hasLottoNumber(LottoNumber compareLottoNumber) {
        return this.lottoNumbers
                .contains(compareLottoNumber);
    }
}
