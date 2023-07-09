package blackjack.domain.card;

import java.util.Objects;

public class Card {
    private final Denomination denomination;
    private final Suit suit;
    private final static String NULL_EXCEPTION_MESSAGE = "Denomination 또는 Suit로 null이 존재합니다.";

    public Card(Denomination denomination, Suit suit) {
        Objects.requireNonNull(denomination, NULL_EXCEPTION_MESSAGE);
        Objects.requireNonNull(suit, NULL_EXCEPTION_MESSAGE);
        
        this.denomination = denomination;
        this.suit = suit;
    }

    public Denomination getDenomitation() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return denomination.getName() + suit.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Card other = (Card) o;

        return this.getDenomitation() == other.getDenomitation()
                && this.getSuit() == other.getSuit();
    }
}
