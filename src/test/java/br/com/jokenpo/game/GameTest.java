package br.com.jokenpo.game;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class GameTest {

    @Test
    public void ShouldStartGame(){
        startGame();
    }

    private void startGame() {
        System.out.println("Do you want to play solo or two players?");
        Integer numberOfPlayers = 2;
        if(numberOfPlayers == 2) {
            toBattle();
        }
    }

    private void toBattle() {

    }

}
