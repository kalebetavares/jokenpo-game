package br.com.jokenpo.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class InicialTest {

   @Test
   public void StarGameWithOnePlayer(){
      Integer numbersPlayer = 1;

      if(numbersPlayer == 1) {
         startGameWithComputer();
      } else{
         System.out.println("Number invalid!");
      }
      assertEquals(1, numbersPlayer);
   }

   @Test
   public void StarGameWithTwoPlayer(){
      Integer numbersPlayer = 2;

      if(numbersPlayer == 2) {
         startGameWithTwoPlayers();
      } else{
         System.out.println("Number invalid!");
      }
      assertEquals(2, numbersPlayer);
   }

   private void startGameWithTwoPlayers() {
   }

   private void startGameWithComputer() {
   }


   @Test
   public void PaperWinsFromStone() {
      String player1 = "stone";
      String player2 = "paper";

      String result = null;
      if (player1.equals("stone") && player2.equals("paper")) {
         result = "Player 2 win!";
         System.out.println(result);
      } else {
         result = "Player 1 win!";
         System.out.println(result);
      }
      assertEquals("Player 2 win!", result);
   }

   @Test
   public void StoneWinsFromScissor() {
      String jogador1 = "stone";
      String jogador2 = "scissor";

      String result = null;
      if (jogador1.equals("stone") && jogador2.equals("scissor")) {
         result = "Player 1 win!";
         System.out.println(result);
      } else {
         result = "Player 2 win!";
         System.out.println(result);
      }
      assertEquals("Player 1 win!", result);
   }

   @Test
   public void ScissorWinsFromPaper() {
      String jogador1 = "paper";
      String jogador2 = "scissor";

      String result = null;
      if (jogador1.equals("paper") && jogador2.equals("scissor")) {
         result = "Player 2 win!";
         System.out.println(result);
      } else {
         result = "Player 1 win!";
         System.out.println(result);
      }
      assertEquals("Player 2 win!", result);
   }
}
