package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.plaf.synth.ColorType;

import Gamedisplay.Display;
import manager.Gamemanager;

public class Gamesetup implements Runnable {
	private Thread thread;
	private Display display;
	private String title;
	private int width,height;
	private BufferStrategy buffer;
	private Graphics g;
	private Gamemanager manager;
	
	
	public void init() {
		display=new Display(title,width,height);
	 manager =new  Gamemanager();
     manager.init();
	}

	public Gamesetup(String title,int width,int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		
	}
	public synchronized void start() {
		if(thread==null) {
		thread =new Thread(this);
         thread.start();
		}
		
		
	}
    public synchronized void stop() {
    	try { 
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   public void render() {
	    buffer = display.canvas.getBufferStrategy();
	    if (buffer==null) {
	         	 
	    display.canvas.createBufferStrategy(3);	
         return;
         
	    }
	    g=buffer.getDrawGraphics();
	    g.clearRect(0, 0, width, height);

        manager.render(g);
	    buffer.show();
	    g.dispose();
  
    }
    public void run() {
    	init();
    	int fps=50;
    	double timepertick=1000000000/fps;
    	double delta=0;
    	long current=System.nanoTime();
    	
    	
    	while(true) {
    		delta=delta+(System.nanoTime()-current)/timepertick;
    		current=System.nanoTime();
    		if(delta>=1) {
    			tick();
    		
    		render();
    		delta--;
    		}
    	}
    	
    }

	private void tick() {

     manager.tick();
	}
}
