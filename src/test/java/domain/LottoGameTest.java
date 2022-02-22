package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {

    public static final String PARAMETERIZED_TEST_DISPLAY_FORMAT =
            DISPLAY_NAME_PLACEHOLDER + " [" + ARGUMENTS_PLACEHOLDER + "]";

    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {1, 14, 50})
    void create_initLottos(int lottoCount) {
        LottoGame game = LottoGame.create(lottoCount);

        assertThat(game.getLottos().size()).isEqualTo(lottoCount);
    }

    @Test
    void create_eachLottoIsDifferent() {
        LottoGame game = LottoGame.create(20);

        Set<Lotto> noDuplicateLottoSet = new HashSet<>(game.getLottos());
        assertThat(noDuplicateLottoSet.size())
                .isEqualTo(game.getLottos().size());
    }
}