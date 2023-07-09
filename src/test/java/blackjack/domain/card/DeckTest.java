package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DeckTest {

    @Test
    void getInstance_test() {
        Deck deck = Deck.getInstance();
        assertThat(deck).isInstanceOf(Deck.class);
    }

    @Test
    void draw_test() {
        Deck deck = Deck.getInstance();
        Card card = deck.draw();
        int totalDeckSize = 52;

        assertThat(card).isInstanceOf(Card.class);
        assertThat(deck.size()).isEqualTo(totalDeckSize - 1);
    }
}
