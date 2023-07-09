package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.state.finished.Blackjack;
import blackjack.domain.state.running.Hit;

public class StateFactory {
    public static State firstDraw(Card card1, Card card2) {
        Cards cards = new Cards(card1, card2);

        if (cards.isBlackjack())
            return new Blackjack(cards);
        return new Hit(cards);
    }
}
