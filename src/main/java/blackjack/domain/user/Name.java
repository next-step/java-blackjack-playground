package blackjack.domain.user;

import java.util.Objects;

public class Name {

    private final String name;
    private final static String NULL_NAME_EXCEPTION_MESSAGE = "이름은 null이될 수 없습니다";

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        Objects.requireNonNull(name, NULL_NAME_EXCEPTION_MESSAGE);
    }

    public String value() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
