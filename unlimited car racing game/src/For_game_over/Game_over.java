package For_game_over;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import designing.Board;

public class Game_over extends JPanel {

	public int x = 100, y = 150, c = 300, e = 350;
	public int f_size = 100;
	private JButton exitButton;
	private static boolean samne = false, samne_for_go = false,
			samne_for_score = true;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, f_size));
		g.drawString("THANKS FOR PLAY", x, y);
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, f_size));
		g.drawString("GameOver", c, y + 150);
		g.drawString(
				"Score:"
						+ String.valueOf(Board.score + Board.f_gulir_sonkha
								* 20 + Board.u_gulir_sonkha * 50), e, y + 300);

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if (samne_for_go) {
			x += 3;
			if (x > 410)
				samne_for_go = false;
		} else {
			x -= 3;
			if (x < 0)
				samne_for_go = true;
		}

		if (samne_for_score) {

			c += 3;
			if (c > 845)
				samne_for_score = false;
		} else {
			c -= 3;
			if (c < 0)
				samne_for_score = true;
		}

		if (samne) {

			int gh, hg;
			gh = Board.score + Board.f_gulir_sonkha * 20 + Board.u_gulir_sonkha
					* 50;
			if (gh < 10)
				hg = 985;
			else if (gh < 100)
				hg = 935;
			else if (gh < 1000)
				hg = 885;
			else if (gh < 10000)
				hg = 835;
			else if (gh < 10000)
				hg = 785;
			else
				hg = 745;

			e += 3;
			if (e > hg) {
				samne = false;
			}
		} else {
			e -= 3;
			if (e < 0)
				samne = true;
		}*/

		repaint();

	}

	public Game_over() {
		super();

		setLayout(new BorderLayout());

		exitButton = new JButton("EXIT");
		exitButton.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
		add(exitButton, BorderLayout.SOUTH);

		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(-1);
			}
		});

	}
}
