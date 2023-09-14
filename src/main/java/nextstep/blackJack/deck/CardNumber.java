package nextstep.blackJack.deck;

public enum CardNumber {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    J(10), Q(10), K(10);
    private final Integer number;

    CardNumber(Integer number) {
        this.number = number;
    }
    public Integer getNumber() {
        return this.number;
    }

    public boolean isAce(){
        return this.equals(ACE);
    }
}
