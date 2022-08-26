package br.com.jokenpo.game;

import br.com.jokenpo.game.model.Card;
import br.com.jokenpo.game.model.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTest {
    private Deck cardsPlayer1;
    private Deck cardsPlayer2;
    private String playerWin;
    private List<Integer> cardsComputer = new ArrayList<>();
    private Integer randomNumber = ThreadLocalRandom.current().nextInt(0, 2);

    @BeforeEach
    public void initialize(){
       this.cardsPlayer1 = new Deck();
       this.cardsPlayer2 = new Deck();

       for(int i = 1; i >= 3; i++){
           this.cardsComputer.add(i);
       }
       Collections.shuffle(cardsComputer);
    }

    @Test
    public void PaperWinsFromStone(){
        startGame();

        assertEquals("Player 1 win!", playerWin);
    }

    private void startGame() {
        System.out.println("Do you want to play solo or two players?");
        Integer numberOfPlayers = 2;

        if(numberOfPlayers == 2) {
            toBattleTwoPlayer();
        }
        else {
            toBattleComputer();
        }
    }

    private void toBattleComputer(){
        System.out.println("Which symbol do you want to play?\n1-Paper 2-Stone 3-Scissor");
        int numberCard1 = 1;
        int numberCard2 = cardsComputer.get(randomNumber);

        initialize();

        cardsPlayer1.playCard(numberCard1);
        cardsPlayer2.playCard(numberCard2);

        battleOfCardsComputer(cardsPlayer1.getCard(), cardsPlayer2.getCard());
    }

    private void toBattleTwoPlayer() {
        System.out.println("Which symbol do you want to play?\n1-Paper 2-Stone 3-Scissor");
        int numberCard1 = 1;
        int numberCard2 = 2;

        initialize();

        cardsPlayer1.playCard(numberCard1);
        cardsPlayer2.playCard(numberCard2);

        battleOfCards(cardsPlayer1.getCard(), cardsPlayer2.getCard());
    }

    private void battleOfCardsComputer(Card card1, Card card2) {
        int result = compare(card1, card2);
        if(card1.equals(card2)) System.out.println("Players drew!");
        else if (result > 0) {
            playerWin = "Player 1 win!";
            System.out.println(playerWin);
        } else {
            playerWin = "Computer win!";
            System.out.println(playerWin);
        }
    }


    private void battleOfCards(Card card1, Card card2) {
        int result = compare(card1, card2);
        if(card1.equals(card2)) System.out.println("Players drew!");
        else if (result > 0) {
            playerWin = "Player 1 win!";
            System.out.println(playerWin);
        } else {
            playerWin = "Player 2 win!";
            System.out.println(playerWin);
        }
    }

    private int compare(Card c1, Card c2) {
        if(c1.equals(Card.PAPER) && c2.equals(Card.STONE) ||
                c1.equals(Card.STONE) && c2.equals(Card.SCISSOR) ||
                c1.equals(Card.SCISSOR) && c2.equals(Card.PAPER)){
            return 1;
        }
        return 0;
    }
}
