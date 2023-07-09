package blackjack.domain.user;

import blackjack.domain.card.Cards;
import blackjack.domain.state.State;

public abstract class AbstractUser implements User {
    private final Name name;
    private final Betting betting;
    protected State state;

    public AbstractUser(Name name, Betting betting, State state) {
        this.name = name;
        this.betting = betting;
        this.state = state;
    }

    public Name getName() {
        return name;
    }

    public Betting getBetting() {
        return betting;
    }

    protected void changeState(State state) {
        this.state = state;
    }

    public void stay() {
        changeState(state.stay());
    }

    public boolean isFinishied() {
        return state.isFinishied();
    }

    public boolean isBlackjack() {
        return getCards().isBlackjack();
    }

    protected Cards getCards() {
        return state.cards();
    }

    public Integer score() {
        return getCards().score();
    }

    @Override
    public String toString() {
        String cardsInString = getCards().toString();

        return getName().value() + " 카드: " + cardsInString;
    }
}
