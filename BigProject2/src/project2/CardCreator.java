package project2;

import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class CardCreator {
		

		public int CardValue() {
		int cardvalue=0;
		SecureRandom cardpicker = new SecureRandom();
		
		
		String [] facevalue = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		String [] suit = {"Hearts","Clubs","Spades","Diamonds"};
		
		int drawsuit = cardpicker.nextInt(3);
		int drawface = cardpicker.nextInt(12);
		
		System.out.println("The " + facevalue[drawface] + " of " + suit[drawsuit] + " is dealt");
		
		switch (facevalue[drawface]){
		case "Ace": {cardvalue=1; break;}//case end
		case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "10":{cardvalue=drawface+1;break;}//end case
		case "Jack": case "Queen": case "King": {cardvalue=10;}//end case
		}//switch end
		
		
		return(cardvalue);}//end CardValue

		
		
		
		
		//Hit or Stay Buttons JOPtionPanes
		public int HitStay(){
			String[] buttons = {"Hit", "Stay"};
			int hitcommand = JOptionPane.showOptionDialog(null,"What do you want to do?","Title",
					JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[0]);
		return(hitcommand);}//end HitStay method
}//end class CardCreator
