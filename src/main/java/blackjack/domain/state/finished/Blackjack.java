package blackjack.domain.state.finished;

import blackjack.domain.card.Cards;
import blackjack.domain.user.Dealer;

// 블랙잭(Blackjack): 처음 두 장의 카드 합이 21인 경우, 베팅 금액의 1.5배
public class Blackjack extends Finished {
    public Blackjack(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate(Dealer dealer) {
        if (cards().isBlackjack() && dealer.isBlackjack())
            return 0;
        return 1.5;
    }
}
