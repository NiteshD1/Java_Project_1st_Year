package manager;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Gamedisplay.Display;
import entity.Enemymotor;
import entity.Motor;
import graphics.Loadimage;
import world.World;

public class Gamemanager {
	
    private Motor motor;
    private Loadimage load;
    private World world;
    private ArrayList<Enemymotor> enmotor;
    long delay=2;
    long time=System.currentTimeMillis();
	

	public Gamemanager() {
		// TODO Auto-generated constructor stub
	}
	public void init() {
		world=new World();
		motor =new Motor();
		motor.init();
		load=new Loadimage();
		load.init();
		enmotor=new ArrayList<Enemymotor>();
		
		
	} 
	public void tick() {
		Random rand=new Random(); 
		int randx=rand.nextInt(330);
		int randy=rand.nextInt(Display.height);
		   while(randx<120) {
			   randx=rand.nextInt(330);
		   }
		  for(int i=0;i<enmotor.size();i++) { 
		   int px=Motor.x;
		   int py=Motor.y-Motor.ofset;
		   int ex=Enemymotor.x;
		   int ey=Enemymotor.y-Motor.ofset;
		          if(px<ex+40&&px+40>ex&&py<ey+40&&py+40>ey) {
		        	  enmotor.remove(i);
		        	  i--;
		        	  Motor.speed=0;
		          }
		  }
		 long elapsed=  (System.currentTimeMillis()-time)/1000;
		 if(elapsed>delay&&Motor.speed>7) {
		
		enmotor.add(new Enemymotor(randx,-randy+Motor.ofset));
		time=System.currentTimeMillis();
		 }
		//motor
		motor.tick();
		//enemy motor
		for(int i=0;i<enmotor.size();i++) {
			enmotor.get(i).tick();
		}
		
		
	}
	public void render(Graphics g) {

     world.render(g);
       
     motor.render(g);
     for(int i=0;i<enmotor.size();i++) {
    	 enmotor.get(i).render(g);
     }
	}
	

}
