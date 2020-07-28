package anim;

import java.awt.Color;
import java.awt.Graphics;

public class Rect {
	private Graphics g;

	public Rect() {
	
	}

	public void render() {
		g.setColor(Color.green);
		g.fillRect(0,5,77, 32);
	}
}
