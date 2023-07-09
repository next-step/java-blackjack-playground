package blackjack.domain.user;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Names implements Iterable<Name> {
    private final List<Name> names;

    private static final String SPLIT_DELIMITER = ",";

    public Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(List<Name> names) {
        return new Names(names);
    }

    public static Names of(String names) {
        String trimmedNames = names.trim();
        return of(Arrays.stream(trimmedNames.split(SPLIT_DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    @Override
    public Iterator<Name> iterator() {
        return names.iterator();
    }

}
