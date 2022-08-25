package br.com.jokenpo.game.service;

import br.com.jokenpo.game.model.Card;
import br.com.jokenpo.game.model.Deck;

import java.util.Comparator;
import java.util.Scanner;

public class GameService implements Comparator<Card>{
    private Scanner input = new Scanner(System.in);
    private Deck cardsPlayer1 = new Deck();
    private Deck cardsPlayer2 = new Deck();

    public void startGame() {
        System.out.println("Do you want to play solo or two players?");
        Integer numberOfPlayers = this.input.nextInt();
        if(numberOfPlayers == 2) {
            System.out.println("Welcome to Jokenpo!");
            toBattle();
        }
    }

    private void toBattle() {
        System.out.println("Which symbol do you want to play?\n1-Paper 2-Stone 3-Scissor");
        System.out.println("Player 1:");
        Integer numbercard1 = input.nextInt();
        System.out.println("Player 2:");
        Integer numberCard2 = input.nextInt();

        cardsPlayer1.playCard(numbercard1);
        cardsPlayer2.playCard(numberCard2);

        battleOfCards(cardsPlayer1.getCard(), cardsPlayer2.getCard());
    }

    private void battleOfCards(Card card1, Card card2) {
        Integer result = compare(card1, card2);
        if(card1.equals(card2)) System.out.println("Players drew!");
        else if (result > 1) {
            System.out.println("Player 1 win!");
        } else {
            System.out.println("Player 2 win!");
        }
    }

    @Override
    public int compare(Card c1, Card c2) {
        if(c1.equals(Card.PAPER) && c2.equals(Card.STONE) ||
                c1.equals(Card.STONE) && c2.equals(Card.SCISSOR) ||
                c1.equals(Card.SCISSOR) && c2.equals(Card.PAPER)){
            return 1;
        }
        return 0;
    }
}
