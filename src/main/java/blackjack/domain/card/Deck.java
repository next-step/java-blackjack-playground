package blackjack.domain.card;

public class Deck {
    private final static Cards DECK = new Cards();
    private static Deck instance = null;

    private Deck() {
        for (Denomination denomination : Denomination.values()) {
            for (Suit suit : Suit.values()) {
                DECK.add(new Card(denomination, suit));
            }
        }
    }

    public static Deck getInstance() {
        if (instance == null)
            instance = new Deck();
        return instance;
    }

    public Card draw() {
        return DECK.pop();
    }

    public Integer size() {
        return DECK.size();
    }
}
