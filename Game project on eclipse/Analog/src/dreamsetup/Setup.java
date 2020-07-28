package dreamsetup;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import display.Display;

public class Setup implements Runnable{
	private int size;
	private String title;
	private Display display;
	private Thread thread;
	private Graphics2D g;
	private BufferStrategy buffer;

	public Setup(String title,int size) {
		this.size=size;
		this.title=title;
		
	}
	public void init() {
		display=new Display( title,size);
		
		
	}
    public synchronized void start() {
    	if (thread==null) {
    		thread =new Thread(this);
    		thread.start();
    	}
    	
    }
    public void render() {
    	buffer=display.canvas.getBufferStrategy();
    	if(buffer==null) {
    		display.canvas.createBufferStrategy(3);
    		return;
    	}
    	g=(Graphics2D)buffer.getDrawGraphics();
    	g.clearRect(0, 0, size, size);
    	
    	g.setColor(Color.black);
    	int center=size/2;
    	
    	g.fillOval(10, 10,size-20, size-20);
    	g.setColor(Color.white);
    	g.fillOval(20, 20,size-40, size-40);
    	g.setColor(Color.red);
    	g.fillOval(center-10,center-10,20,20);
    	int anglex,angley,angx1,angx2,angy1,angy2;
    	int radius=center-50,rad1,rad2;
    	double position;
    	double time=System.currentTimeMillis();
    	for(int i=1;i<=12;i++) {
    		position=i/12.0*Math.PI*2;
    		
    	       anglex=(int)((center)+Math.sin(position)*radius);
    	       angley=(int)((center)-Math.cos(position)*radius); 
    	      String s =Integer.toString(i);
    	      g.setColor(Color.black);
    	      g.setFont(new Font("arial", Font.BOLD,23));
    	      g.drawString(s,anglex,angley);
    	      }
    	
    	rad2=center-20;
    	for(int i=1;i<=60;i++) {
    	position=i/60.0*Math.PI*2;
    	rad1=center-30;
    	if(i%5==0) 
		rad1=center-40;
	
    		
    	angx1=(int)(center+Math.sin(position)*rad1);
    	angy1=(int)(center-Math.cos(position)*rad1);
    	angx2=(int)(center+Math.sin(position)*rad2);
    	angy2=(int)(center-Math.cos(position)*rad2);
    	g.setColor(Color.red);
    	g.setStroke(new BasicStroke(2));
    
    	         g.drawLine(angx1, angy1, angx2, angy2);
    	        
    
    	}
    	//hour
    	
    	radius=center-120;
    	time=System.currentTimeMillis()/(1000*60.0*60.0*12.0)*Math.PI*2;
    	anglex=(int)(center+Math.sin(time)*radius);
    	angley=(int)(center-Math.cos(time)*radius);
    	g.setColor(Color.BLACK);
         g.setStroke(new BasicStroke(8));
    	g.drawLine(center, center, anglex, angley);
    	g.setStroke(new BasicStroke(0));
    	
    	
    	//minute
    	radius=center-80;
    	time=System.currentTimeMillis()/(1000*60.0*60)*Math.PI*2;
    	anglex=(int)(center+Math.sin(time)*radius);
    	angley=(int)(center-Math.cos(time)*radius);
    	g.setColor(Color.black);
         g.setStroke(new BasicStroke(6));
    	g.drawLine(center, center, anglex, angley);
    	g.setStroke(new BasicStroke(0));
    	
    	
    	//second
    	radius=center-50;
    	time=System.currentTimeMillis()/(1000*60.0)*Math.PI*2;
    	anglex=(int)(center+Math.sin(time)*radius);
    	angley=(int)(center-Math.cos(time)*radius);
    	g.setColor(Color.red);
    	g.drawLine(center, center, anglex, angley);
    	
    	
    	g.setColor(Color.red);
    	g.fillOval(center-10,center-10,20,20);
    	buffer.show();
    	g.dispose();
    	
    	
    }
    public synchronized void stop() {
    	try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void run() {
    	init();
    
    	
    	while(true) {
    	render();
    	}
    	
    }


}
