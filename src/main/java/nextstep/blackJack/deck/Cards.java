package nextstep.blackJack.deck;

import java.util.*;

public class Cards {
    private final Stack<Card> cards;

    private Cards() {
        this.cards = createCards();
    }

    public int size(){
        return cards.size();
    }

    public static Cards ofGame(){
        return new Cards();
    }

    public void shuffleCards(){
        Collections.shuffle(this.cards);
    }

    private void addToCards(CardShape cardShape, Stack<Card> cards) {
        for (CardNumber cardNumber : CardNumber.values()) {
            cards.add(new Card(cardShape, cardNumber));
        }
    }

    public Stack<Card> createCards() {
        Stack<Card> cards = new Stack<>();
        for (CardShape cardShape : CardShape.values()) {
            addToCards(cardShape, cards);
        }
        return cards;
    }

    public Card pickCard() {
        return cards.pop();
    }
}
