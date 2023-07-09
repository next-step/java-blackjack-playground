package blackjack.domain.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players() {
        players = new ArrayList<>();
    }

    public void add(Player player) {
        players.add(player);
    }

    public Player get(int index) {
        return players.get(index);
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Players other = (Players) o;
        return Objects.equals(players, other.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.joining("\n"));
    }
}
