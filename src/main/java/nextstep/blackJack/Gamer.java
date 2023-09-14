package nextstep.blackJack;

import nextstep.blackJack.deck.Card;
import nextstep.blackJack.deck.CardNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Gamer {
    private final Set<Card> cards;
    private final String name;
    private Integer balance;
    private Integer cardSum = 0;
    public Gamer(final String name) {
        this.name = name;
        this.balance = 100000;
        this.cards = new HashSet<>();
    }

    public void betMoney(Integer betMoney) {
        this.balance -= betMoney;
    }

    public String getName(){
        return this.name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void addCard(Card card) {
        if (!cards.contains(card)){
            cardSum += card.getCardNumber().getNumber();
        }
        cards.add(card);
    }

    public boolean isHaveAce(){
        return this.cards.stream().map(Card::getCardNumber).anyMatch(CardNumber::isAce);
    }

    public boolean isFull(){
        return this.cardSum > 21;
    }

    public Integer getSum() {
//        cardSum = cards.stream().map(Card::getCardNumber).map(CardNumber::getNumber).reduce(0, Integer::sum);
        return cardSum;
    }

    private void calculateAce(){
        if (isHaveAce()){
            this.cardSum = getMax();
        }
    }

    private int getMax() {
        return Math.max(getAbsoluteSum(cardSum),getAbsoluteSum(cards.stream().map(Card::getCardNumber).map(CardNumber::getNumber).reduce(0, Integer::sum) + 10));
    }

    private int getAbsoluteSum(int cardSum){
        return Math.abs(cardSum - 21);
    }
}
