package br.com.jokenpo.game;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer numberOfPlayers = input.nextInt();

        if(numberOfPlayers == 1){
            System.out.println("Welcome! You will play against the computer.");
        } else if(numberOfPlayers == 2) {
            System.out.println("Welcome! You will play against another player");
        } else {
            System.out.println("Invalid entry number");
        }
    }
}
