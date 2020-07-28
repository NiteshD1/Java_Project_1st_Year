package entity;

import java.awt.Graphics;

import graphics.Loadimage;

public class Enemymotor {
	public static int x,y;

	public Enemymotor(int x,int y) {
		this.x=x;
		this.y=y;
		
	}
	public void tick() {
		y+=5;
		
	}
	public void render(Graphics g) {
		g.drawImage(Loadimage.emotor, x, y-Motor.ofset, 40,70,null);
	}
	

}
