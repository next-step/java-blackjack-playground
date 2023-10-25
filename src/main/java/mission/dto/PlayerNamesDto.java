package mission.dto;

import java.util.List;

public class PlayerNamesDto {

    private final List<String> playerNames;

    public PlayerNamesDto(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
