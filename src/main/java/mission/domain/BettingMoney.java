package mission.domain;

public class BettingMoney {

    private static final String RANGE_EXCEPTION_MESSAGE = "0원보다 큰 금액을 입력해주세요.";
    private int bettingMoeny;

    private BettingMoney(int bettingMoney) {
//        validateRange(bettingMoney);
        this.bettingMoeny = bettingMoney;
    }

    private void validateRange(int bettingMoney) {
        if (!isInRange(bettingMoney)) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isInRange(int bettingMoney) {
        return bettingMoney > 0;
    }

    public static BettingMoney from(int bettingMoney) {
        return new BettingMoney(bettingMoney);
    }

    //    - PlyaerWithCard.player.winBlackJack(bettingmoney +1.5배 시켜줌)

    public void winBlackJack() {
        bettingMoeny = (int) (bettingMoeny * 1.5);
    }

    public void draw() {
        bettingMoeny = 0;
    }

    public int getBettingMoeny() {
        return bettingMoeny;
    }

    public void lossMoney() {
        bettingMoeny = -bettingMoeny;
    }
}
