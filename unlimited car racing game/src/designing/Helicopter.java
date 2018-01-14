package designing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import For_Audio.Helicopter_sound;
import Running.Play;

public class Helicopter implements Runnable {

	public int x, y, guli_marar_joggota = 0;
	public boolean visible;
	public static int radius = 16, dif = 20, chaka_ghorar_speed = 3,
			helicopter_speed = 1;

	private Random r;
	private static BufferedImage h_photo;
	public Helicopter_sound helicopter_sound;

	public Helicopter() {

		x = 0;
		y = 0;
		guli_marar_joggota = 0;
		visible = false;

		helicopter_sound = new Helicopter_sound();
		
		h_photo = null;
		try {
			h_photo = ImageIO.read(getClass().getResource("h.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Helicopter(String str) {

		r = new Random();
		x = Play.a;
		y = r.nextInt(400);
		visible = true;

		guli_marar_joggota = 0;
		helicopter_sound = new Helicopter_sound("run");

		Thread newthread = new Thread(this);
		newthread.start();

	}

	public void helicopter_er_wheel_designing(Graphics g) {
		// TODO Auto-generated method stub

		int e = 32, f = 165;

		g.setColor(Color.BLACK);

		// pichoner chaka----------
		g.drawOval(x + f, y + e, radius, radius);
		for (int i = 0; i < 12; i++)
			g.fillArc(x + f, y + e, radius, radius,
					(chaka_ghorar_speed + (i * (dif + 10))), dif);

	}

	public void run() {

		if (visible) {
			chaka_ghorar_speed += 7;

			x -= helicopter_speed;

			if (x < -200) {
				visible = false;
				helicopter_sound.stop_helicopter_colar_sound();
			}

			Board.ghum();

			run();
		}
	}

	public void draw_helicopter(Graphics g) {

		g.setColor(Color.BLUE);

		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.drawImage(h_photo, x, y, null);

	}

}
