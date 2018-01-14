package designing;

import java.awt.Color;
import java.awt.Graphics;

import Running.Play;

public class H_guli implements Runnable{

	public int x, y;
	public boolean visible;
	public static int niche_porar_speed = 2, bas = 10;

	public H_guli() {
		x = 0;
		y = 0;
		visible = false;
	}

	public H_guli(String str,int i, int j) {
		x = i;
		y = j;
		visible = true;
		
		//sounding er option ekhane thakbe
		
		Thread newthread = new Thread(this);
		newthread.start();
	}

	public void draw_H_guli(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillOval(x, y, bas, bas);

	}

	public void run() {
		if(visible){
			y += niche_porar_speed;
			if (y > Play.b )
				visible = false;
			
			Board.ghum();
			run();
		}
	}

}
