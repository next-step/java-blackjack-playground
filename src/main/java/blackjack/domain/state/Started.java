package blackjack.domain.state;

import blackjack.domain.card.Cards;

public abstract class Started implements State {

    protected final Cards cards;

    public Started(final Cards cards) {
        this.cards = cards;
    }

    public Started() {
        this.cards = new Cards();
    }

    @Override
    public Cards cards() {
        return cards;
    }
}
