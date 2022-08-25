package br.com.jokenpo.game.model;

public enum Card {
    PAPER(1), STONE(2), SCISSOR(3);

    private Integer value;
    Card(Integer value) {
     this.value = value;
    }
}
