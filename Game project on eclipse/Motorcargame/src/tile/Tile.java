package tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	private BufferedImage texture;
	public static final int tilewidth=31;
	public static final int tileheight=31;
	public static Tile[] tiles=new Tile[5];
	public static Roadtile roadtile=new Roadtile(0);
	public static Grasstile grasstile=new Grasstile(1);
	public static Footpathtile footpathtile =new Footpathtile(2);
       public Tile(BufferedImage texture,int id) {
    	   this.texture=texture;
    	   tiles[id]=this;
       }

    public void render(Graphics g,int x,int y) {
    	g.drawImage(texture,x,y,null);
    }           

}
