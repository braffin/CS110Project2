
package project2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class PlayAgainButtons {
    
   private JFrame mainFrame;
   
   private JLabel headerLabel;
   private JLabel statusLabel;
   
   private JPanel controlPanel;

   public PlayAgainButtons(){
      prepareGUI();
   }

   public static void main(String[] args){
      PlayAgainButtons  swingControlDemo = new PlayAgainButtons();      
      swingControlDemo.AgainButtons();
   }//end void main

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
   }//end void prepareGUI

   public void AgainButtons(){

      headerLabel.setText("Do you want to play again?"); 

      JButton yesbutton = new JButton("Yes");        
      JButton nobutton = new JButton("No");

      yesbutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            statusLabel.setText("Yes Button clicked.");
         }//end void          
      });//end action listener

      nobutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            statusLabel.setText("No Button clicked.");
            System.exit(0);
         }//endpublic void
      });//end action listener

      controlPanel.add(yesbutton);
      controlPanel.add(nobutton);     

      mainFrame.setVisible(true);  
   }//end void showButtonDemo
}//end class PlayAgainButtons
