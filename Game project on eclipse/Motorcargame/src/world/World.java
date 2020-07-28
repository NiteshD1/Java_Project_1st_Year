package world;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Gamedisplay.Display;
import entity.Motor;
import tile.Tile;

public class World {
	private int tile[][];
	public static int width,height,k,l;
	
	public World() {
		loadworld("res/text.txt");
		
	}
	private void loadworld(String path) {
		String file=loadfile(path);
		String[] space=file.split("\\s+");
		 width=Integer.parseInt(space[0]);
		 height=Integer.parseInt(space[1]);
		tile=new int[width][height];
           for(int i=0;i<width;i++) {
        	   for(int j=0;j<height;j++) {
        		   tile[i][j]=Integer.parseInt(space[2+(i+j*width)]);
        	   }
           }		
	}
	public String loadfile(String path) {
		StringBuilder sr=new StringBuilder();
		try {
			BufferedReader reader=new BufferedReader(new FileReader(path));
			String line;
			while((line=reader.readLine()) != null) {
				sr.append(line+"\n");
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sr.toString();
	}
	
	
	
 
   public void render(Graphics g) {
	   int start=Math.max(0,(Motor.ofset-100)/Tile.tileheight);
	   int end =Math.min(height, (Motor.ofset+Display.height)/Tile.tileheight);
	   for(int i=0;i<width;i++) {
		  
	     for(int j=start;j<end;j++) {
	    	 
			  Tile t=Tile.tiles[tile[i][j]];
			  t.render(g, i*Tile.tilewidth, j*Tile.tileheight-Motor.ofset+100);
			  
			  }
		   }
	   }
	   
   }	


