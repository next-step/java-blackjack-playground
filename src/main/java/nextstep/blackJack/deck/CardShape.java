package nextstep.blackJack.deck;

import java.util.Arrays;

public enum CardShape {
    SPADE("SPADE"),
    HEART("HEART"),
    DIAMOND("DIAMOND"),
    CLOVER("CLOVER");

    private final String name;

    CardShape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
