package blackjack.domain.card;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Cards {

    private final List<Card> cards;
    private final static String NULL_CARD_EXCEPTION_MESSAGE = "card의 값은 null이 될 수 없습니다";
    private final static String DUPLICATED_CARD_EXCEPTION_MESSAGE = "이미 같은 card가 존재합니다";
    private final static String DELEMITER = ", ";
    private final static Integer BLACKJACK_SCORE = 21;
    private final static Random RANDOM = new Random();

    public Cards() {
        this.cards = new LinkedList<>();
    }

    public Cards(Card... cards) {
        this();
        for (Card card : cards) {
            this.cards.add(card);
        }
    }

    public void add(Card card) {
        Objects.requireNonNull(card, NULL_CARD_EXCEPTION_MESSAGE);
        if (cards.contains(card))
            throw new IllegalArgumentException(DUPLICATED_CARD_EXCEPTION_MESSAGE);
        cards.add(card);
    }

    public Integer size() {
        return cards.size();
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public boolean isBlackjack() {
        return score() == BLACKJACK_SCORE;
    }

    public boolean isBust() {
        return score() > BLACKJACK_SCORE;
    }

    public Integer score() {
        int initialScore = cards.stream()
                .mapToInt(card -> card.getDenomitation().getScore())
                .sum();

        if (initialScore <= BLACKJACK_SCORE)
            return initialScore;

        return cards.stream()
                .mapToInt(card -> card.getDenomitation().getScore(initialScore))
                .sum();
    }

    public Card pop() {
        Integer randomIndex = RANDOM.nextInt(cards.size());
        Card card = cards.get(randomIndex);
        cards.remove(card);
        return card;
    }

    @Override
    public String toString() {
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(DELEMITER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Cards other = (Cards) o;

        return Objects.equals(cards, other.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cards);
    }
}
