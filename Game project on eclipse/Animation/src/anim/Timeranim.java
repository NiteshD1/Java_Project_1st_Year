package anim;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.w3c.dom.css.Rect;

public class Timeranim extends JComponent implements ActionListener,MouseMotionListener{
	private JFrame frame;
	double bx=275;
	double by=0;
	double px=275;
	double valx=8;
	double valy=4;
	Graphics g;
	public Rect rect;
	public static JLabel lab;
	private ArrayList<Rect> arr=new ArrayList<Rect>();
	   
	public void getrect() {
		arr.add(rect);
	}

	public Timeranim() {
		
		Timer t=new Timer(100,this);
		t.start();
		
		getrect();
		
	}

	public static void main(String[] args) {
		Timeranim anim=new Timeranim();
		JFrame frame;
		
		lab=new JLabel("GAME OVER");
		frame=new JFrame("Animation");

		frame.setSize(700,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	
		frame.add(anim);
		
		frame.addMouseMotionListener(anim);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		


		 
		   if(bx>670||bx<0) {
			valx=-valx;
			
		}
		   
		if(by<0||(bx>px && bx<px+180 && by>460)) {
			valy=-valy;
			
		}
		    if(by>333) {


		    }
		if(valx>0 && valx<25) {
		   valx+=0.3f;
		}
		if(valx<0 && valx>-25) {
			
			   valx-=0.3f;
			}
		if(valy>0&& valy<20) {
			   valy+=0.3f;
			}
		if(valy<0 && valy>-20) {
			   valy-=0.3f;
			}
		 
		   
		   bx=bx+valx;
		  by=by+valy;
		 
		
	repaint();
		
	}
	public void paintComponent(Graphics g) {
		//screen color
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0,0,700, 600);
		
		//draw paddle
		g.setColor(new Color(110,61,23));
		g.fillRect((int)px, 490, 180, 30);
		//draw ball
		g.setColor(Color.black);
		g.fillOval((int)bx, (int)by, 30, 30);
		arr.get(0);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		px=e.getX();
		px=px-90;
		repaint();
		
	}

	
}
