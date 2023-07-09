package blackjack.controller;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.state.State;
import blackjack.domain.state.StateFactory;
import blackjack.domain.user.Betting;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.Names;
import blackjack.domain.user.Player;
import blackjack.domain.user.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Controller {
    private final static Deck deck = Deck.getInstance();

    private Controller() {
    }

    public static void run() {
        Players players = enrollPlayers();
        Dealer dealer = enrollDealer();

        OutputView.printInitStatus(players, dealer);

        playerDrawPhase(players);
        dealerDrawPhase(dealer);

        OutputView.printResult(players, dealer);
    }

    private static Players enrollPlayers() {
        Names names = Names.of(InputView.inputPlayerNames());
        Players players = new Players();

        names.forEach((name) -> {
            Betting betting = Betting.of(InputView.inputPlayerBettingMoney(name));

            Card card1 = deck.draw();
            Card card2 = deck.draw();
            State firstState = StateFactory.firstDraw(card1, card2);

            players.add(new Player(name, betting, firstState));
        });
        return players;
    }

    private static Dealer enrollDealer() {
        Card card1 = deck.draw();
        Card card2 = deck.draw();
        State firstState = StateFactory.firstDraw(card1, card2);

        return new Dealer(firstState);
    }

    private static void playerDrawPhase(Players players) {
        players.forEach((player) -> {
            while (!player.isFinishied() && wantDraw(player)) {
                player.draw(deck.draw());
                OutputView.printPlayerStatus(player);
            }
        });
    }

    private static void dealerDrawPhase(Dealer dealer) {
        OutputView.printDealerDrew(dealer);
        dealer.draw(deck.draw());
    }

    private static boolean wantDraw(Player player) {
        String intention = InputView.inputPlayerIntention(player);
        boolean drawStops = intention.equals("n");
        if (drawStops)
            player.stay();
        return intention.equals("y");
    }
}
