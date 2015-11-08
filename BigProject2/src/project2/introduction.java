package project2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class introduction {
	
	public static final SecureRandom randomName = new SecureRandom(); 
	
	@SuppressWarnings("unused")
	public static void main(String [] args) throws IOException {
			
		GameStart();
		String newname = GetName();  
		
	}
	
	public static void GameStart() throws IOException {
		
		// defines path to image, a file from the path, an image from the file
		String path = "title.png";
		File file = new File(path);
		BufferedImage image = ImageIO.read(file);
				        
		//puts the image in the "label" part
		JLabel label = new JLabel(new ImageIcon(image));
				        
		JFrame title = new JFrame();
		title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.getContentPane().add(label);
		title.pack();
		title.setLocationRelativeTo(null);
		title.setVisible(true); 
				
		// sleep timer code, re: Marshall
		try{Thread.sleep(5000);}
		catch(Exception e){}; 
				
		// close out of the intro jFrame stack overflow
		title.dispose();
		
	}
	
	public static String GetName() {
		String newname; 
		
		JOptionPane.showMessageDialog(null, "This is a high stakes game. An alias is encouraged.","New Name",JOptionPane.INFORMATION_MESSAGE);
		
		String[] NameOptions = { "Enter Name", "Random Name" };

	    int NewName = JOptionPane.showOptionDialog(null, "What would you like to do?", "Prompt",
	        JOptionPane.ERROR_MESSAGE, 3, null, NameOptions, NameOptions[0]);

	    
	    if (NewName == 1) {
		String[] name = {"Randy", "Tod", "Michael", "Drew", "Cole", "Alvin", "Emma", "Leanne", "Brenda", "Cher", "Mary", "Julia"};
		int first = randomName.nextInt(12);
		newname = name[first];
		JOptionPane.showMessageDialog(null, "Your new identity is " + newname + ".","New Name",JOptionPane.INFORMATION_MESSAGE);
	    }
		
	    else {
		newname = 
				JOptionPane.showInputDialog("Please enter your new identity:"); 
	    }
	    
		return(newname);
	}
}
