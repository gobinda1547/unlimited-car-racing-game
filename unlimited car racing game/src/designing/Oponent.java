package designing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.text.ChangedCharSetException;

import For_Audio.Car_sound;
import Running.Play;

import designing.Board;

public class Oponent implements Runnable {
	public int x, y;
	public boolean visible;
	public static BufferedImage opn;
	public static int radius = 18, dif = 20, chaka_ghorar_speed = 10,
			quick = 2;
	public Car_sound car_sound;

	public Oponent() {

		x = 0;
		y = 0;
		visible = false;
		car_sound = new Car_sound();
		try {
			opn = null;
			opn = ImageIO.read(getClass().getResource("b.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Oponent(String st) {
		x = Play.a;
		y = Play.b - 150;
		visible = true;
		car_sound = new Car_sound("run");

		Thread newthread = new Thread(this);
		newthread.start();

	}

	public void oponent_car_designing(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.drawImage(opn, x, y, null);

	}

	public void oponent_car_wheel_designing(Graphics g) {
		// TODO Auto-generated method stub

		int e = 28;
		g.setColor(Color.RED);

		// samner chaka---------
		g.drawOval(x + 13, y + e, radius, radius);
		for (int i = 0; i < 12; i++)
			g.fillArc(x + 13, y + e, radius, radius,
					(chaka_ghorar_speed + (i * (dif + 10))), dif);

		// pichoner chaka----------
		g.drawOval(x + 90, y + e, radius, radius);
		for (int i = 0; i < 12; i++)
			g.fillArc(x + 90, y + e, radius, radius,
					(chaka_ghorar_speed + (i * (dif + 10))), dif);

	}

	public void run() {
		// TODO Auto-generated method stub
		while (visible) {
			x -= quick;
			chaka_ghorar_speed += 1;
			Board.ghum();
		}
	}

}
