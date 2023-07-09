package blackjack.domain.state.running;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.state.State;
import blackjack.domain.state.finished.Bust;
import blackjack.domain.state.finished.Stay;

// 힛(Hit): 처음 2장의 상태에서 카드를 더 뽑는 것
public class Hit extends Running {

    public Hit(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final Card card) {
        cards.add(card);
        if (cards.isBust())
            return new Bust(cards);
        return new Hit(cards);
    }

    @Override
    public State stay() {
        return new Stay(cards);
    }
}
