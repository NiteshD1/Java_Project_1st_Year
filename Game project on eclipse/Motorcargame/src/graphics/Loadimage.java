package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loadimage {
	public static BufferedImage fullimage,fullimage1,grass,road,footpath,pmotor,emotor;
	public static void init() {
		fullimage=imageloader("/tile.PNG");
		fullimage1=imageloader("/motor.PNG");
		crop();
		
	}
		public static BufferedImage imageloader(String path) {
			try {
				return ImageIO.read(Loadimage.class.getResource(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
			return null;
			
		}
	

public static void crop() {
	grass=fullimage.getSubimage(0, 0,120,110);
	road=fullimage.getSubimage(122, 0, 120, 110);
	footpath=fullimage.getSubimage(244, 0, 120, 110);
	pmotor=fullimage1.getSubimage(0, 0, 214, 417);
	emotor=fullimage1.getSubimage(225, 0, 214, 417);
}
}
