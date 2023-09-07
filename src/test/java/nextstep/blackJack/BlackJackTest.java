package nextstep.blackJack;

import nextstep.blackJack.deck.Cards;
import org.junit.jupiter.api.Test;

public class BlackJackTest {
    @Test
    void gameStartAndPickCard(){
        Gamer gamer = new GameUser("DK");
        Cards deck = Cards.ofGame();
        deck.shuffleCards();
        gamer.addCard(deck.pickCard());
        gamer.addCard(deck.pickCard());
    }
}
