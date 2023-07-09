package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import blackjack.domain.Fixture;

public class CardsTest {
    Cards cards;

    @BeforeEach
    void setup() {
        cards = new Cards();
    }

    @AfterEach
    void teardown() {
        cards = null;
    }

    @Test
    void add_null_test() {
        assertThatNullPointerException().isThrownBy(() -> {
            cards.add(null);
        });
    }

    @Test
    void add_duplicated_card_test() {
        cards.add(Fixture.ACE_SPADE);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cards.add(Fixture.ACE_SPADE);
        });
    }

    @Test
    void sum_test_under_bust_with_ace() {
        cards.add(Fixture.ACE_SPADE);
        cards.add(Fixture.KING_SPADE);

        assertThat(cards.score()).isEqualTo(21);
    }

    @Test
    void sum_test_over_bust_with_ace() {
        cards.add(Fixture.ACE_SPADE);
        cards.add(Fixture.KING_SPADE);
        cards.add(Fixture.KING_HEART);

        assertThat(cards.score()).isEqualTo(21);
    }

    @Test
    void isBust_test() {
        cards.add(Fixture.KING_SPADE);
        cards.add(Fixture.KING_HEART);

        assertThat(cards.isBust()).isFalse();

        cards.add(new Card(Denomination.TWO, Suit.HEARTS));
        assertThat(cards.isBust()).isTrue();
    }

    @Test
    void pop_test() {
        Card card = Fixture.KING_SPADE;
        cards.add(card);

        assertThat(cards.pop().equals(card)).isTrue();
        assertThat(cards.size()).isEqualTo(0);
    }

    @Test
    void equals_test() {
        Card card1 = Fixture.KING_SPADE;
        Card card2 = Fixture.KING_HEART;
        cards.add(card1);
        cards.add(card2);

        Cards other = new Cards();
        other.add(card1);
        other.add(card2);

        assertThat(cards.equals(other)).isTrue();

        cards.add(Fixture.TWO_SPADE);

        assertThat(cards.equals(other)).isFalse();
    }

    @Test
    void toString_test() {
        Card card1 = Fixture.KING_SPADE;
        Card card2 = Fixture.KING_HEART;
        cards.add(card1);
        cards.add(card2);

        assertThat(cards.toString().equals("K스페이드, K하트")).isTrue();
    }
}
