package blackjack.domain.user;

public class Betting {

    private final Double betting;
    private final static String ARGUMENT_EXCEPTION_STRING = "베팅 금액은 0보다 큰 정수여야 합니다.";
    private final static int MIN_BETTING = 0;

    public Betting(double betting) {
        validate(betting);
        this.betting = betting;
    }

    public static Betting of(String betting) {
        return new Betting(Double.parseDouble(betting));
    }

    private void validate(double betting) {
        if (betting < MIN_BETTING)
            throw new IllegalArgumentException(ARGUMENT_EXCEPTION_STRING);
    }

    public Double value() {
        return betting;
    }
}
