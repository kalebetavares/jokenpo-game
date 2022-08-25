package br.com.jokenpo.game.model;

import br.com.jokenpo.game.model.Card;

public class Deck {
    private Card card;

    public void playCard(Integer numberCard) {
        switch (numberCard) {
            case 1: this.card = Card.PAPER;
            break;
            case 2: this.card = Card.STONE;
            break;
            case 3: this.card = Card.SCISSOR;
            break;
        }
    }
    public Card getCard() {
        return this.card;
    }
}
