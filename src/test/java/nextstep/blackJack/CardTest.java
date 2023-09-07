package nextstep.blackJack;

import nextstep.blackJack.deck.Card;
import nextstep.blackJack.deck.CardNumber;
import nextstep.blackJack.deck.CardShape;
import nextstep.blackJack.deck.Cards;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardTest {
    @Test
    void pickCardTest(){
        Cards cards = Cards.ofGame();
        Card card = cards.pickCard();
        assertThat(card).isEqualTo(new Card(CardShape.CLOVER, CardNumber.K)); // 젤 끝놈
    }

    @Test
    void pickShuffledCardTest(){
        Cards cards = Cards.ofGame();
        cards.shuffleCards();
        Card card = cards.pickCard();
        assertThat(card).isNotEqualTo(new Card(CardShape.CLOVER, CardNumber.K)); // 젤 끝놈이고, 1/48 확률로 실패한다...
        assertThat(cards.size()).isEqualTo(47);
    }

    @Test
    void cardSizeTest(){
        Cards cards = Cards.ofGame();
        assertThat(cards.createCards().size()).isEqualTo(48);
        cards.pickCard();
        assertThat(cards.size()).isEqualTo(47);
    }

    @Test
    void getCardInfoTest(){
        Card card = new Card(CardShape.SPADE, CardNumber.ACE);

    }
}
