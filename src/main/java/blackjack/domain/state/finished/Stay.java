package blackjack.domain.state.finished;

import blackjack.domain.card.Cards;
import blackjack.domain.user.Dealer;

// 스테이(Stay): 카드를 더 뽑지 않고 차례를 마치는 것
public class Stay extends Finished {
    public Stay(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate(Dealer dealer) {
        if (dealer.isBust() || cards().score() > dealer.score())
            return 1;
        if (!dealer.isBust() && cards().score() == dealer.score())
            return 0;
        return -1;
    }
}
