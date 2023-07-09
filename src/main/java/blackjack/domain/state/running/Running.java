package blackjack.domain.state.running;

import blackjack.domain.card.Cards;
import blackjack.domain.state.Started;
import blackjack.domain.user.Betting;
import blackjack.domain.user.Dealer;

public abstract class Running extends Started {

    public Running(final Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinishied() {
        return false;
    }

    @Override
    public double profit(Dealer dealer, Betting betting) {
        throw new UnsupportedOperationException();
    }
}
