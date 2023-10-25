package mission.dto;

import mission.domain.BettingMoney;
import mission.domain.Player;

public class PlayerInfoDto {

    private final BettingMoney bettingMoney;
    private final String playerName;

    public PlayerInfoDto(String playerName, BettingMoney bettingMoney) {
        this.playerName = playerName;
        this.bettingMoney = bettingMoney;
    }

    public BettingMoney getBettingMoney() {
        return bettingMoney;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Player toPlayer() {
        return Player.from(playerName, bettingMoney);
    }
}
