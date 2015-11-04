
package project2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class PlayGameButtons {
    
	public int Play;
	
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public PlayGameButtons(){
      prepareGUI();
   }

   public static void main(String[] args){
      PlayGameButtons  swingControlDemo = new PlayGameButtons();      
      swingControlDemo.PlayButtons();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("BlackJack Game");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
  
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   public void PlayButtons(){

      headerLabel.setText("Do you want to play Blackjack?"); 

      JButton yesbutton = new JButton("Yes");        
      JButton nobutton = new JButton("No");

      yesbutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            statusLabel.setText("Yes Button clicked.");
            Play=1;
            return;
         }          
      });

      nobutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            statusLabel.setText("No Button clicked.");
            System.exit(0);
         }
      });



      controlPanel.add(yesbutton);
      controlPanel.add(nobutton);
      //controlPanel.add(cancelButton);       

      mainFrame.setVisible(true);  
      
   }
   
}//end class PlayGameButtons
