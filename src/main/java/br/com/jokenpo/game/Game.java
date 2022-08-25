package br.com.jokenpo.game;

import br.com.jokenpo.game.service.GameService;

public class Game {
    public static void main(String[] args) {
        GameService newGame = new GameService();
        newGame.startGame();
    }
}
