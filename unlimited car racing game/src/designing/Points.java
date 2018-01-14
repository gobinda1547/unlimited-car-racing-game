package designing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Robot;
import java.util.Random;

import Running.Play;

public class Points {

	public int x, y;
	public final int porar_speed = 1, points_er_bas = 50;
	public boolean visible;
	private Random random;
	public int which_points;
	public String ch;

	public Points() {

		random = new Random();

		x = random.nextInt(Play.a - 200);
		y = 0;
		visible = true;
		which_points = random.nextInt(5);
		ch = select_point(which_points);

	}

	public void change_position() {
		y += porar_speed;
		if (y > Play.b + 20)
			visible = false;

	}

	public void draw_paints(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 30));
		g.setColor(Color.GREEN);

		g.drawRect(x, y, points_er_bas, points_er_bas);
		g.drawString(ch, x + 15, y + 35);

	}

	private String select_point(int a) {
		// TODO Auto-generated method stub
		if (a == 0)
			ch = new String("S");
		else if (a == 1)
			ch = new String("+");
		else if(a==2)
			ch = new String("M");
		else if(a==3)
			ch = new String("U");
		else
			ch = new String("F");
		

		return ch;
	}

}
