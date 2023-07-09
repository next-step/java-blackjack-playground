package blackjack.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import blackjack.domain.Fixture;
import blackjack.domain.card.Cards;
import blackjack.domain.state.finished.Bust;
import blackjack.domain.state.running.Hit;

public class HitTest {

    @Test
    void hit_test() {
        Hit hit = new Hit(new Cards(Fixture.ACE_SPADE, Fixture.TWO_SPADE));
        State state = hit.draw(Fixture.KING_HEART);
        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void bust_test() {
        Hit hit = new Hit(new Cards(Fixture.KING_HEART, Fixture.KING_SPADE, Fixture.ACE_SPADE));
        State state = hit.draw(Fixture.TWO_SPADE);
        assertThat(state).isInstanceOf(Bust.class);
    }
}
