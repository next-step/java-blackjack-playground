package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class DenominationTest {
    @Test
    void getScore_test() {
        assertThat(Denomination.ACE.getScore(10))
                .isEqualTo(11);
        assertThat(Denomination.ACE.getScore(11))
                .isEqualTo(1);
        assertThat(Denomination.KING.getScore(11))
                .isEqualTo(10);
    }

    @Test
    void getScore_illegalArgumenttExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Denomination.SEVEN.getScore(-1);
        });
    }
}
