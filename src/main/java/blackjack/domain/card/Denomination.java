package blackjack.domain.card;

import java.util.function.Predicate;
import java.util.function.Supplier;

public enum Denomination {
    ACE(11, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K");

    private final int score;
    private final String name;
    private final static Integer BIG_ACE_SCORE = 11;
    private final static Integer BALCKJACK_SCORE = 21;
    private final static Predicate<Integer> scoreBurstPredicate = score -> score + BIG_ACE_SCORE > BALCKJACK_SCORE;
    private final static Supplier<Integer> smallAceScoreSupplier = () -> 1;
    private final static String SCORE_EXCEPTION_MESSAGE = "score는 0보다 작을 수 없습니다.";

    Denomination(final int score, final String name) {
        this.score = score;
        this.name = name;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getScore(int userScore) {
        if (userScore < 0)
            throw new IllegalArgumentException(SCORE_EXCEPTION_MESSAGE);
        if (isAce())
            return getAceScore(userScore);
        return score;
    }

    public String getName() {
        return name;
    }

    private Integer getAceScore(int userScore) {
        if (scoreBurstPredicate.test(userScore))
            return smallAceScoreSupplier.get();
        return BIG_ACE_SCORE;
    }
}
