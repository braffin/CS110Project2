package project2;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

@SuppressWarnings("unused")
final class Driver {

	
	//variables block
	private enum Status {CONTINUE, BUST, WON, PUSH};
	private enum PlayAgain {YES, NO};
	
	static int playerhandvalue=0; 	//total value of all cards in players hand
	static int dealerhandvalue=0;	//total value of all cards dealt to the dealer
	static int cardvalue;			//value of card dealt
	static int hitcommand;			//0 means hit, 1 means stay
	static int losecount=0;			//counts of games lost
	static int wincount=0;			//counts of games won
	static int tiecount=0;			//counts games pushed
	
	static Status gamestatus;		//gamestatus for player to continue game
	static PlayAgain againstatus;			//status for player to play again
	static CardCreator getcardface = new CardCreator(); //reference to get to the class CardCreator
	static introduction intro = new introduction();		//references the introduction class
	static String newname;
	
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args)throws IOException{
		
		intro.GameStart();
		newname = intro.GetName();
		PlayPrompt();
		
		againstatus=PlayAgain.YES;
		for(;againstatus==PlayAgain.YES;){
			playerhandvalue = 0; dealerhandvalue = 0; 
		BlackJackPlayer();		
		
		while(gamestatus==Status.CONTINUE){System.out.println("The Game is Continuing");
		BlackJackCPU();
		System.out.println("Player's Current Hand is: " + playerhandvalue);
		System.out.println("Dealer's Current Hand is: " + dealerhandvalue);
		if(playerhandvalue > dealerhandvalue){gamestatus = Status.WON;}
		if(playerhandvalue < dealerhandvalue){gamestatus = Status.BUST;}
		if(playerhandvalue == dealerhandvalue){gamestatus = Status.PUSH;}
		break;}
		
		while(gamestatus==Status.WON){wincount++;System.out.println("Player Wins!");break;}
		
		while(gamestatus==Status.BUST){losecount++;System.out.println("Player Loses!");break;}
		
		while(gamestatus==Status.PUSH){tiecount++;System.out.println("Player and dealer push!");break;}
		
		System.out.println("Games Won: " + wincount + "\nGames Lost: " + losecount + "\nGames Pushed: " + tiecount);
		
		PlayAgainPrompt();
		}//end for loop
	

	}//end void main
	
	
	
	
	
	
	
	
	
	
	
	//"Do you want to play" Buttons Prompt
	private static void PlayPrompt(){
		String[] buttons = {"Yes", "No"}; 
		int play = JOptionPane.showOptionDialog(null, newname + ", do you want to play Blackjack?","Play Prompt", 
				JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
		if(play==1){System.exit(0);}
		//JOptionPane.; EXIT ON CLOSE
	}//end PlayGame method
	
	
	
	
	
	
	
	
	
	
	
	//Playing BlackJack Game
	private static int BlackJackPlayer(){
		
		do{
			cardvalue = getcardface.CardValue();
			playerhandvalue = playerhandvalue + cardvalue;
			System.out.println("the variable cardvalue is " + cardvalue);
			System.out.println("the variable playerhandvalue is " + playerhandvalue);
			
			if(playerhandvalue>21){gamestatus = Status.BUST;break;}//end if
			
			hitcommand = getcardface.HitStay();
			System.out.println("hitcommand is " + hitcommand);
			gamestatus = Status.CONTINUE;}//end do loop
			while(hitcommand==0);
			
			System.out.println("Players Total Hand value is: " + playerhandvalue);
			
	return(playerhandvalue);}//end BlackJackPlayer
	
	
	
	
	
	
	
	
	
	
	//Runs the BlackJackCode for the Dealer
	private static int BlackJackCPU(){
		do{
			cardvalue = getcardface.CardValue();
			dealerhandvalue = dealerhandvalue + cardvalue;
			System.out.println("the variable cardvalue is " + cardvalue);
			System.out.println("the variable dealerhandvalue is " + dealerhandvalue);
			try{Thread.sleep(1500);}catch(Exception e){};}//end do loop
			while(dealerhandvalue<17);
			if(dealerhandvalue>21){dealerhandvalue=0;} //this makes busting win for the Player
			System.out.println("Dealer's Total Hand value is: " + dealerhandvalue);
	return(dealerhandvalue);}//end BlackJackCPU
	
	
	
	
	
	
	
	
	
	
	
	
	//"Do you want to play again" Buttons Prompt
	private static void PlayAgainPrompt(){
		String[] buttons = {"Yes", "No"}; 
		int playagain = JOptionPane.showOptionDialog(null, newname + ", do you want to play again?","Play Again Prompt", 
				JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
		if(playagain==1){System.exit(0);}
//	return(playagain);
	}//end PlayAgainPrompt method
}//end class Driver