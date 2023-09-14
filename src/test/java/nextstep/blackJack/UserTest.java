package nextstep.blackJack;

import nextstep.blackJack.deck.Card;
import nextstep.blackJack.deck.CardNumber;
import nextstep.blackJack.deck.CardShape;
import nextstep.blackJack.deck.Cards;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    @Test
    void userCreateTest() {
        String name = "DK";
        Gamer gamer = new GameUser(name);
        assertThat(gamer.getName()).isEqualTo(name);
    }

    @Test
    void userMoneyTest(){
        Integer betMoney = 10000;
        Gamer gamer = new GameUser("DK");
        gamer.betMoney(betMoney); // 베팅 하면 잔고 차감하고 머니 리턴해야함
        assertThat(gamer.getBalance()).isEqualTo(90000);
    }
    @Test
    void addCard() {
        Cards cards = Cards.ofGame();
        cards.shuffleCards();
        Card card = cards.pickCard();
        Gamer gamer = new GameUser("DK");
        gamer.addCard(card);
        assertThat(gamer.getSum()).isNotEqualTo(0);
    }

    @Test
    void isContainsAce() {
        Card card = new Card(CardShape.SPADE, CardNumber.ACE);
        Gamer gamer = new GameUser("DK");
        gamer.addCard(card);
        assertThat(gamer.isHaveAce()).isTrue();
    }

    @Test
    void userSetTest_NO_DUPLICATE() {
        Card card = new Card(CardShape.SPADE, CardNumber.J);
        Card card1 = new Card(CardShape.SPADE, CardNumber.Q);
        Card card2 = new Card(CardShape.SPADE, CardNumber.K);
        Gamer gamer = new GameUser("DK");
        gamer.addCard(card);
        gamer.addCard(card1);
        gamer.addCard(card2);
        assertThat(gamer.isFull()).isTrue();
    }
    @Test
    void userSetTest_DUPLICATE() {
        Card card = new Card(CardShape.SPADE, CardNumber.K);
        Card card1 = new Card(CardShape.SPADE, CardNumber.K);
        Card card2 = new Card(CardShape.SPADE, CardNumber.K);
        Gamer gamer = new GameUser("DK");
        gamer.addCard(card);
        gamer.addCard(card1);
        gamer.addCard(card2);
        assertThat(gamer.getSum()).isEqualTo(10);
    }

    @Test
    void userSetDoWorks(){
        // ACE 를 가지고 있을 경우, 절대값 현재 섬 - 21vs 현재섬 + 10 - 21 중 더 가까운 녀석으로 ACE를 취급해야 한다.
        Card card = new Card(CardShape.SPADE, CardNumber.ACE);
        Card card1 = new Card(CardShape.SPADE, CardNumber.K);
        Card card2 = new Card(CardShape.SPADE, CardNumber.Q);
        Card card3 = new Card(CardShape.SPADE, CardNumber.J);
        Gamer gamer = new GameUser("DK");
        gamer.addCard(card);
        gamer.addCard(card1);
        gamer.addCard(card2);
        gamer.addCard(card3);

    }
}
