package mission.domain;

public class Player {

    private final PlayerName playerName;
    private final BettingMoney bettingMoney;

    private Player(PlayerName playerName, BettingMoney bettingMoney) {
        this.playerName = playerName;
        this.bettingMoney = bettingMoney;
    }

    public static Player from(String playerName, BettingMoney bettingMoney) {
        return new Player(new PlayerName(playerName), bettingMoney);
    }

}
