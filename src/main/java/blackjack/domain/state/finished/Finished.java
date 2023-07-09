package blackjack.domain.state.finished;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.state.Started;
import blackjack.domain.state.State;
import blackjack.domain.user.Betting;
import blackjack.domain.user.Dealer;

// 끝난 상태를 표현하기 위한 클래스
// profit()을 얻을 수 있지만 draw(), stay()는 사용이 불가능 하도록 예외처리
public abstract class Finished extends Started {
    public Finished(final Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinishied() {
        return true;
    }

    @Override
    public double profit(Dealer dealer, Betting betting) {
        return betting.value() * earningRate(dealer);
    }

    public abstract double earningRate(Dealer dealer);

    @Override
    public State draw(final Card card) {
        throw new UnsupportedOperationException();
    }

    @Override
    public State stay() {
        throw new UnsupportedOperationException();
    }

}
