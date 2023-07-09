package blackjack.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.Fixture;
import blackjack.domain.state.State;
import blackjack.domain.state.StateFactory;

import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    void firstPhase() {
        State firstState = StateFactory.firstDraw(Fixture.KING_HEART, Fixture.KING_SPADE);

        Dealer dealer = new Dealer(firstState);

        assertThat(dealer.initStatus().equals("딜러: K하트")).isTrue();
    }
}
