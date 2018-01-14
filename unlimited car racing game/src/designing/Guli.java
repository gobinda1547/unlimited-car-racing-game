package designing;

import java.awt.Graphics;

import For_Audio.Gulir_sound;
import Running.Play;
import designing.Board;

public class Guli implements Runnable {

	public int x, y;
	public final int gulir_speed = 5;
	public boolean visible;
	public Gulir_sound gulir_sound;
	public int gulir_time_counter = 0;

	public Guli() {

		x = 0;
		y = 0;
		visible = false;
		gulir_time_counter = 0;
		gulir_sound = new Gulir_sound();
	}

	public Guli(String str) {
		
		x = Board.mine.x;
		y = Board.mine.y;
		visible = true;
		gulir_time_counter = 0;
		gulir_sound = new Gulir_sound("run");

		Thread newthread = new Thread(this);
		newthread.start();

	}

	public void run() {
		if (visible) {
			x += gulir_speed;
			if (x > Play.a + 50) {
				visible = false;
			}

			Board.ghum();
			run();
		}
	}

	public void draw_guli(Graphics g) {
		g.fillRect(x + 120, y + 30, 20, 5);
	}

}
