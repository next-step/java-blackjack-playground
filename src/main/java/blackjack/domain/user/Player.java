package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.state.State;

public class Player extends AbstractUser {

    public Player(Name name, Betting betting, State state) {
        super(name, betting, state);
    }

    public double profit(Dealer dealer) {
        return state.profit(dealer, getBetting());
    }

    @Override
    public void draw(Card card) {
        changeState(state.draw(card));
    }

}
