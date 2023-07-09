package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;

public class Fixture {
    public static final Card ACE_SPADE = new Card(Denomination.ACE, Suit.SPADES);
    public static final Card TWO_SPADE = new Card(Denomination.TWO, Suit.SPADES);
    public static final Card KING_SPADE = new Card(Denomination.KING, Suit.SPADES);
    public static final Card EIGHT_SPADE = new Card(Denomination.EIGHT, Suit.SPADES);
    public static final Card NINE_SPADE = new Card(Denomination.NINE, Suit.SPADES);
    public static final Card KING_HEART = new Card(Denomination.KING, Suit.HEARTS);
}
