package br.com.jokenpo.game.service;

import br.com.jokenpo.game.model.Card;
import br.com.jokenpo.game.model.Deck;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameService {
    private Scanner input = new Scanner(System.in);
    private Deck cardsPlayer1 = new Deck();
    private Deck cardsPlayer2 = new Deck();
    private List<Integer> cardsComputer = new ArrayList<>();
    private int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);

    public void startGame() {
        System.out.println("Do you want to play solo or two players?");
        int numberOfPlayers = this.input.nextInt();
        System.out.println("Welcome to Jokenpo!");
        if(numberOfPlayers == 2) {
            toBattleTwoPlayers();
        } else {
            toBattleComputer();
        }
    }

    private void toBattleComputer(){
        shuffleComputer();

        System.out.println("Which symbol do you want to play?\n1-Paper 2-Stone 3-Scissor");
        System.out.println("Player: ");
        int numberCard1 = input.nextInt();
        int numberCard2 = cardsComputer.get(randomNumber);

        cardsPlayer1.playCard(numberCard1);
        cardsPlayer2.playCard(numberCard2);

        battleOfCardsComputer(cardsPlayer1.getCard(), cardsPlayer2.getCard());
    }

    private void toBattleTwoPlayers() {
        System.out.println("Which symbol do you want to play?\n1-Paper 2-Stone 3-Scissor");
        System.out.println("Player 1:");
        Integer numberCard1 = input.nextInt();
        System.out.println("Player 2:");
        Integer numberCard2 = input.nextInt();

        cardsPlayer1.playCard(numberCard1);
        cardsPlayer2.playCard(numberCard2);

        battleOfCards(cardsPlayer1.getCard(), cardsPlayer2.getCard());
    }

    private void battleOfCardsComputer(Card card1, Card card2) {
        int result = compare(card1, card2);
        if(card1.equals(card2)) System.out.println("Players drew!");
        else if (result > 0) {
            System.out.println("Player 1 win!");
        } else {
            System.out.println("Computer win!");
        }
    }

    private void battleOfCards(Card card1, Card card2) {
        int result = compare(card1, card2);
        if(card1.equals(card2)) System.out.println("Players drew!");
        else if (result > 0) {
            System.out.println("Player 1 win!");
        } else {
            System.out.println("Player 2 win!");
        }
    }

    private void shuffleComputer(){
        for(int i = 1; i <= 3; i++){
            this.cardsComputer.add(i);
        }
        Collections.shuffle(this.cardsComputer);
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
