package project2;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Driver {

	
	public static void main(String[] args){
		DeckOfCards myDeck = new DeckOfCards();
		myDeck.shuffle();
		PlayPrompt();
		System.out.println("Player is Dealt: " + myDeck.dealCard() + "\n" + myDeck.dealCard());
//		int playagain =PlayAgainPrompt();
//		System.out.println(playagain);
	}//end void main
	
	
	//"Do you want to play" Buttons Prompt
	private static void PlayPrompt(){
		String[] buttons = {"Yes", "No"}; 
		int play = JOptionPane.showOptionDialog(null, "Do you want to play Blackjack?","Play Prompt", 
				JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
		if(play==1){System.exit(0);}		
	}//end PlayGame method
	
	
	
	
	//"Do you want to play again" Buttons Prompt
	private static int PlayAgainPrompt(){
		String[] buttons = {"Yes", "No"}; 
		int playagain = JOptionPane.showOptionDialog(null, "Do you want to play again?","Play Again Prompt", 
				JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
		if(playagain==1){System.exit(0);}
	return(playagain);}//end PlayAgainPrompt method
}//end class Driver