package blackjack.domain.state.finished;

import blackjack.domain.card.Cards;
import blackjack.domain.user.Dealer;

// 버스트(Bust): 카드 총합이 21을 넘는 경우. 배당금을 잃는다.
public class Bust extends Finished {

    public Bust(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate(Dealer dealer) {
        return 0;
    }

}
