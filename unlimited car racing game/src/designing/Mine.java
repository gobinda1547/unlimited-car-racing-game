package designing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Running.Play;

import designing.Board;

public class Mine {

	public static int x = 250, y = Play.b + 20;
	public static boolean visible, piche, samne;
	public BufferedImage mycar;
	public static int radius = 19, dif = 20, speed = 3,
			speed_kom_korar_jonno = 0;
	public static int chaka_ghorar_speed = 0;

	public void car_wheel_designing(Graphics g) {
		// TODO Auto-generated method stub
		int e = 28, f = 12;
		g.setColor(Color.RED);

		// samner chaka---------
		g.drawOval(x + 80 + f, y + e, radius, radius);
		for (int i = 0; i < 12; i++)
			g.fillArc(x + 80 + f, y + e, radius, radius,
					(chaka_ghorar_speed + (i * (dif + 10))), dif);

		// pichoner chaka----------
		g.drawOval(x + f, y + e, radius, radius);
		for (int i = 0; i < 12; i++)
			g.fillArc(x + f, y + e, radius, radius,
					(chaka_ghorar_speed + (i * (dif + 10))), dif);

		// u++;
	}

	public void car_designing(Graphics g) {
		// TODO Auto-generated method stub

		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.drawImage(mycar, x, y, null);
	}

	public Mine() {
		mycar = null;
		try {
			mycar = ImageIO.read(getClass().getResource("1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void change(int speed) {
		x += this.speed * speed;
	}

	public void car_position_change() {

		
		if (piche && x >= 0) {
			change(-1);
			chaka_ghorar_speed += 5;
		}
		if (samne && x <= Play.a - 140) {
			change(1);
			chaka_ghorar_speed -= 5;
		}
		if (!piche && !samne) {
			if (Board.auto_running) {
				chaka_ghorar_speed -= 2;
				speed_kom_korar_jonno++;
				Helicopter.helicopter_speed = 2;
				Oponent.quick = 3;
				if (speed_kom_korar_jonno % 10 == 0)
					x += 1;
			} else {
				Helicopter.helicopter_speed = 1;
				Oponent.quick = 2;
			}
		}

	}

}
