package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import blackjack.domain.Fixture;

public class CardTest {
    Card card;

    @BeforeEach
    void setup() {
        card = new Card(Denomination.ACE, Suit.CLUBS);
    }

    @Test
    void null_argument_test() {
        assertThatNullPointerException().isThrownBy(() -> {
            new Card(null, null);
        });

        assertThatNullPointerException().isThrownBy(() -> {
            new Card(null, Suit.CLUBS);
        });

        assertThatNullPointerException().isThrownBy(() -> {
            new Card(Denomination.ACE, null);
        });
    }

    @Test
    void toString_test() {
        assertThat(card.toString().equals("A클로버"));
    }

    @Test
    void equals_test() {
        assertThat(card.equals(new Card(Denomination.ACE, Suit.CLUBS))).isTrue();
        assertThat(card.equals(Fixture.ACE_SPADE)).isFalse();
    }
}
