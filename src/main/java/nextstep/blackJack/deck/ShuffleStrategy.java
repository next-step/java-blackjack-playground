package nextstep.blackJack.deck;

import java.util.Stack;

@FunctionalInterface
public interface ShuffleStrategy {
    void shuffle(Stack<Card> cards);
}
