package designing;

import java.awt.Color;
import java.awt.Graphics;

public class Bust implements Runnable {

	public boolean visible;
	public boolean[] vis = new boolean[7];
	public int[][] pos = new int[7][2];
	public static int bas = 10;

	public Bust() {

		visible = false;

		for (int i = 0; i < 7; i++) {
			pos[i][0] = 0;
			pos[i][1] = 0;
			vis[i] = false;
		}

	}

	public Bust(String str, int num) {

		for (int i = 0; i < 7; i++) {
			pos[i][0] = Mine.x + 65;
			pos[i][1] = Mine.y;
			vis[i] = true;
		}
		visible = true;

		Thread newthread = new Thread(this);
		newthread.start();

	}

	public void run() {

		if (visible) {
			pos[0][0] -= 3;
			pos[0][1] -= 3;
			pos[1][0] -= 2;
			pos[1][1] -= 4;
			pos[2][0] -= 1;
			pos[2][1] -= 5;
			pos[3][0] += 0;
			pos[3][1] -= 5;
			pos[4][0] += 1;
			pos[4][1] -= 5;
			pos[5][0] += 2;
			pos[5][1] -= 4;
			pos[6][0] += 3;
			pos[6][1] -= 3;

			if (pos[3][1] < -300)
				visible = false;
			
			
			Board.ghum();
			run();
		}

	}

	public void draw_bust(Graphics g) {

		g.setColor(Color.BLUE);
		for (int i = 0; i < 7; i++) {
			if (vis[i])
				g.fillOval(pos[i][0], pos[i][1], bas, bas);
		}

	}

}
