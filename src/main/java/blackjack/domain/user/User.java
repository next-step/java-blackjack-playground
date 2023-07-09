package blackjack.domain.user;

import blackjack.domain.card.Card;

public interface User {
    Name getName();
    Betting getBetting();    
    void draw(Card card);
    void stay();
    boolean isFinishied();
    boolean isBlackjack();
    Integer score();
}
