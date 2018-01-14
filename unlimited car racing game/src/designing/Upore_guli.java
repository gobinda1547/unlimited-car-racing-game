package designing;

import java.awt.Color;
import java.awt.Graphics;

import For_Audio.Gulir_sound;
import For_Audio.Upore_gulir_sound;

public class Upore_guli implements Runnable {

	public int x, y;
	public boolean visible;
	public final int upore_gulir_speed = 5;
	public Upore_gulir_sound gulir_sound;

	public Upore_guli() {

		x = 0;
		y = 0;
		visible = false;
		gulir_sound = new Upore_gulir_sound();
	}

	public Upore_guli(String str) {
		x = Mine.x;
		y = Mine.y;
		visible = true;

		gulir_sound = new Upore_gulir_sound("run");

		Thread newthread = new Thread(this);
		newthread.start();

	}

	public void draw_upore_guli(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x + 50, y, 5, 20);
	}

	public void run() {
		if (visible) {
			y -= upore_gulir_speed;
			if (y < -50) {
				visible = false;
				if (gulir_sound != null)
					gulir_sound.stop_upore_gulir_sound();
			}

			Board.ghum();
			run();
		}
	}

}
