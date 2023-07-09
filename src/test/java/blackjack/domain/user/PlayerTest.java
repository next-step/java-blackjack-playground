package blackjack.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import blackjack.domain.Fixture;
import blackjack.domain.state.State;
import blackjack.domain.state.StateFactory;

public class PlayerTest {
    Player player;
    Player blackjackPlayer;
    Dealer dealer;
    Dealer blackjackDealer;

    @BeforeEach
    void setup() {
        Name name = new Name("hyeonwoo");
        Betting betting = new Betting(100);

        State firstState = StateFactory.firstDraw(Fixture.EIGHT_SPADE, Fixture.KING_SPADE);
        player = new Player(name, betting, firstState);
        player.draw(Fixture.TWO_SPADE);
        
        
        State blackjack = StateFactory.firstDraw(Fixture.ACE_SPADE, Fixture.KING_SPADE);
        blackjackPlayer = new Player(name, betting, blackjack);

        State dealerState = StateFactory.firstDraw(Fixture.TWO_SPADE, Fixture.KING_SPADE);
        dealer = new Dealer(dealerState);
        dealer.draw(Fixture.ACE_SPADE);
        
        State blackjackDealerState = StateFactory.firstDraw(Fixture.ACE_SPADE, Fixture.KING_SPADE);
        blackjackDealer = new Dealer(blackjackDealerState);
    }

    @Test
    void draw_isFinished_true() {
        assertThat(player.isFinishied()).isFalse();
    }

    @Test
    void bust() {
        player.draw(Fixture.KING_HEART);

        assertThat(player.isFinishied()).isTrue();
        assertThat(player.profit(dealer)).isEqualTo(0.0);
    }

    @Test
    void user_toString() {
        assertThat(player.toString().equals("hyeonwoo 카드: 8스페이드, K스페이드, 2스페이드")).isTrue();
    }

    @Test
    void profit_player_score_bigger_than_dealer_score() {
        player.stay();

        assertThat(player.profit(dealer)).isEqualTo(100.0);
    }

    @Test
    void profit_should_be_0_when_both_blackjack_case() {
        player.stay();
        assertThat(blackjackPlayer.profit(blackjackDealer)).isEqualTo(0.0);
    }

    @Test
    void profit_should_be_negative100_when_only_dealer_is_blackjack() {
        player.stay();
        assertThat(player.profit(blackjackDealer)).isEqualTo(-100.0);
    }

    @Test
    void profit_should_be_0_when_bust_player_low_dealer_score() {
        player.draw(Fixture.KING_HEART);
        assertThat(player.profit(dealer)).isEqualTo(0.0);
    }
}
