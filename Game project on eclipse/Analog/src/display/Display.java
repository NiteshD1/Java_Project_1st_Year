package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private int size;
	private String title;
	private JFrame frame;
	public static Canvas canvas;

	public Display(String title,int size) {
		this.size=size;
		this.title=title;
		createdisplay();
		
	}
	public void createdisplay() {
		frame=new JFrame(title);
		frame.setSize(size,size);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(size,size));
		canvas.setFocusable(false);
		canvas.setBackground(Color.green);
		frame.add(canvas);
		frame.pack();
		
	}

}
