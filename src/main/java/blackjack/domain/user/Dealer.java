package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.state.State;

public class Dealer extends AbstractUser {

    public static final Integer STANDARD = 16;

    public Dealer(State state) {
        super(new Name("딜러"), null, state);
    }

    @Override
    public void draw(Card card) {
        if (canDraw()) {
            changeState(state.draw(card));
            return;
        }
        stay();
    }

    public String initStatus() {
        return getName().value() + ": " + getCards().get(0).toString();
    }

    public boolean isBust() {
        return getCards().isBust();
    }

    public boolean canDraw() {
        return score() <= STANDARD;
    }
}
