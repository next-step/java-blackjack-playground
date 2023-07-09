package blackjack.view;

import blackjack.domain.user.Dealer;
import blackjack.domain.user.Player;
import blackjack.domain.user.Players;

public class OutputView {
    public static void printInitStatus(Players players, Dealer dealer) {
        printNewLine();
        System.out.println(dealer.initStatus());
        System.out.println(players);
        printNewLine();
    }

    public static void printPlayerStatus(Player player) {
        System.out.println(player);
    }

    public static void printDealerDrew(Dealer dealer) {
        if (dealer.canDraw()) {
            printNewLine();
            System.out.println("딜러는 " + Dealer.STANDARD + "이하라 한장의 카드를 더 받았습니다.");
            printNewLine();
        }
    }

    public static void printResult(Players players, Dealer dealer) {
        printNewLine();
        System.out.println(dealer + " - 결과: " + dealer.score());
        players.forEach(player -> {
            System.out.println(player + " - 결과: " + player.score());
        });
        printNewLine();

        System.out.println("## 최종 수익");
        players.forEach(player -> {
            System.out.println(player.getName() + ": " + player.profit(dealer));
        });
    }

    private static void printNewLine() {
        System.out.println();
    }
}
