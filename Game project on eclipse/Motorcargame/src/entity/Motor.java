package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Gamedisplay.Display;
import graphics.Loadimage;
import tile.Tile;
import world.World;

public class Motor implements KeyListener{
	public static int y,x;
	private boolean left,right, up,down,pause;
    public static int ofset;
    public static double speed,brake;
	public void init() {
    Display.frame.addKeyListener(this);
	y=Tile.tileheight*200;
	x=Display.width/2-25;
	ofset=0;
	speed=0.3f;
	brake=0.3f;
	
		
	}
	public void tick() {
		ofset=y-Display.height+100;
	  
		
		if(right) {
			x+=6;
			if(x>330) {
				x=330;
			}
		}
		if(left) {
			x-=6;
			if(x<130) {
				x=130;
			}
		}
		if(up) {
			
			speed+=0.3f;
			
			  if(speed>=10) {
				  speed=10;
			  }
			 
			 
		}
		if(pause) {
			speed=0.3f;
		}
		if(!pause) {
			
			y-=speed;
		}
		if(down) {
			
			brake+=0.3f;
			y+=brake;
			 
		}
		
		
		
	}
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawImage(Loadimage.pmotor,x, y-ofset, 40, 70,null);
		
	}
	
	public void keyPressed(KeyEvent e) {
		int source =e.getKeyCode();
		if(source==KeyEvent.VK_RIGHT) {
			right=true;
		}
		if(source==KeyEvent.VK_LEFT) {
			left=true;
		}
		if(source==KeyEvent.VK_UP) {
			up=true;
		}
		if(source==KeyEvent.VK_DOWN) {
			down=true;
		}
		
		if(source==KeyEvent.VK_SPACE) {
			pause=true;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int source =e.getKeyCode();
		if(source==KeyEvent.VK_RIGHT) {
			right=false;
		}
		if(source==KeyEvent.VK_LEFT) {
			left=false;
		}
		if(source==KeyEvent.VK_UP) {
			up=false;
		}
		if(source==KeyEvent.VK_DOWN) {
			down=false;
		}
		if(source==KeyEvent.VK_SPACE) {
			pause=false;
		}
		
		
		
	}
	
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	

}
