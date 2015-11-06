package project2;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

final class Driver {

	private enum Status {CONTINUE, BUST, WON};
	private enum PlayAgain {YES, NO};
	
	public static void main(String[] args){
		//variables block
		int playerhandvalue=0; 	//total value of all cards in players hand
		int dealerhandvalue=0;	//total value of all cards dealt to the dealer
		int cardvalue;			//value of card dealt to user
		int hitcommand;			//0 means hit, 1 means stay
		int losecount=0;			//counts of games lost
		int wincount=0;			//counts of games won
		
		Status gamestatus;		//gamestatus for player to continue game
		PlayAgain againstatus;	//status for player to play again
		CardCreator getcardface = new CardCreator(); //reference to get to the class CardCreator
		

		
		PlayPrompt();
		do{
		cardvalue = getcardface.CardValue(playerhandvalue);
		playerhandvalue = playerhandvalue + cardvalue;
		System.out.println("the variable cardvalue is " + cardvalue);
		System.out.println("the variable playerhandvalue is " + playerhandvalue);
		
		if(playerhandvalue>21){gamestatus = Status.BUST;break;}//end if
		
		hitcommand = getcardface.HitStay();
		System.out.println("hitcommand is " + hitcommand);
		gamestatus = Status.CONTINUE;}//end do loop
		while(hitcommand==0);
		
		System.out.println("Players Total Hand value is: " + playerhandvalue);
		
		while(gamestatus==Status.CONTINUE){System.out.println("The Game is Continuing");
		gamestatus = Status.WON;break;}
		
		while(gamestatus==Status.WON){wincount++;System.out.println("Player Wins");break;}
		
		while(gamestatus==Status.BUST){losecount++;System.out.println("Player Loses");break;}
		
		System.out.println("Games Won: " + wincount + "\nGames Lost: " + losecount);
		
//		int playagain =PlayAgainPrompt();
//		System.out.println(playagain);
	}//end void main
	
	
	//"Do you want to play" Buttons Prompt
	private static void PlayPrompt(){
		String[] buttons = {"Yes", "No"}; 
		int play = JOptionPane.showOptionDialog(null, "Do you want to play Blackjack?","Play Prompt", 
				JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
		if(play==1){System.exit(0);}
		//JOptionPane.; EXIT ON CLOSE
	}//end PlayGame method
	
	
	
	
	
	//"Do you want to play again" Buttons Prompt
	private static int PlayAgainPrompt(){
		String[] buttons = {"Yes", "No"}; 
		int playagain = JOptionPane.showOptionDialog(null, "Do you want to play again?","Play Again Prompt", 
				JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
		if(playagain==1){System.exit(0);}
	return(playagain);}//end PlayAgainPrompt method
}//end class Driver