package Gamedisplay;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
     private String title;
     public static int width,height;
     public static JFrame frame;
     public static Canvas canvas;
	private Object Color;
     public Display(String title,int width,int height) {
    	 this.title=title;
    	 this.height=height;
    	 this.width=width;
    	 createdisplay();
      
	}
     
     public void createdisplay() {
    	 frame=new JFrame(title);
    	 frame.setSize(width,height);
    	 frame.setVisible(true);
    	 frame.setLocationRelativeTo(null);
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 canvas=new Canvas();
    	 canvas.setPreferredSize(new Dimension(width,height));
         canvas.setFocusable(false); 	
    	 frame.add(canvas);
    	 frame.pack();
    	 
    	 
    	 
    	 
     }

}
