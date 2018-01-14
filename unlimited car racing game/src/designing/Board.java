package designing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JPanel;

import For_Audio.Car_exp;
import For_Audio.Helicopter_exp;
import For_Audio.Pointsexp;
import Running.Play;

public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int x = 250, y = 490, uu = 500, vv = 0, ghumer_time = 10;
	public static int refresh_counter, gulirr_jonno_counter, score = 0;
	public static int life = 5, p_er_counter = 0, f_gulir_sonkha = 50, u_gulir_sonkha = 50;
	public static int counter_helicopter = 0, uporer_gulirr_jonno_counter = 0;
	public static boolean samne_guli, upore_guli_bol;
	private static Oponent[] op = new Oponent[5];
	private static Helicopter[] helicopter = new Helicopter[10];
	public static Points[] points = new Points[5];
	public static Mine mine;
	private static Random r = new Random();
	public Guli[] gulis = new Guli[10];
	public Upore_guli[] u_gulis = new Upore_guli[10];
	public H_guli[] h_guli = new H_guli[10];
	public static Bust[] busts = new Bust[5];
	public static boolean pause_check = false;
	public static boolean auto_running = false, auto_f = false, auto_u = false;
	public boolean gameover = false;

	public Board() {

		refresh_counter = 0;
		gulirr_jonno_counter = 0;
		p_er_counter = 0;
		mine = new Mine();
		for (int i = 0; i < 5; i++) {
			op[i] = new Oponent();
		}

		for (int i = 0; i < 10; i++) {
			helicopter[i] = new Helicopter();
		}

		for (int i = 0; i < 10; i++)
			gulis[i] = new Guli();

		for (int i = 0; i < 10; i++)
			u_gulis[i] = new Upore_guli();
		for (int i = 0; i < 5; i++) {
			points[i] = new Points();
			points[i].visible = false;
		}
		for (int i = 0; i < 5; i++)
			busts[i] = new Bust();

		for (int i = 0; i < 10; i++)
			h_guli[i] = new H_guli();

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		refresh_counter++;
		gulirr_jonno_counter++;
		uporer_gulirr_jonno_counter++;
		counter_helicopter++;
		p_er_counter++;
		setBackground(Color.WHITE);

		oponents_make_korbe_kina();
		helicopter_make_korbe_kina();
		points_make_korbe_kina();
		guli_charbe_kina();
		upore_guli_charbe_kina();
		helicopter_guli_charbe_kina();

		mine.car_designing(g);
		mine.car_wheel_designing(g);
		ononent_car_and_wheel_design(g);
		helicopter_designing(g);
		helicopter_er_wheel_designing(g);
		points_designing(g);
		uporer_guli_desing(g);
		amar_guli_design(g);
		bust_designing(g);
		h_guli_designing(g);

		drawroad(g);

		mine.car_position_change();
		// oponents_car_position_change();
		// helicopter_position_change();
		// gulir_position_change();
		// uporer_gulir_position_change();
		points_er_position_change();
		// buster_position_change();
		// h_gulir_position_change();

		guli_and_oponents_er_colusion();
		upore_guli_and_helicopter_colusion();
		points_and_mine_colusion();
		bust_and_helicopter_colusion();

		score_designing(g);

		game_over_check();

		if (!gameover)
			repaint();

		else {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 150));
			g.drawString("GAME OVER", 250, 200);
			g.setColor(Color.BLUE);
			g.drawString("CLICK TO EXIT", 180, 350);
			g.setColor(Color.RED);
			g.drawString("SCORE: " + String.valueOf(score + f_gulir_sonkha * 10 + u_gulir_sonkha * 20), 180, 500);

		}
		ghum();

	}

	private void helicopter_er_wheel_designing(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (helicopter[i].visible)
				helicopter[i].helicopter_er_wheel_designing(g);
		}
	}

	/*
	 * private void h_gulir_position_change() { // TODO Auto-generated method
	 * stub for (int i = 0; i < 10; i++) { if (h_guli[i].visible) {
	 * h_guli[i].change_position(); } } }
	 */

	private void h_guli_designing(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (h_guli[i].visible) {
				h_guli[i].draw_H_guli(g);
			}
		}
	}

	private void helicopter_guli_charbe_kina() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (helicopter[i].visible) {
				helicopter[i].guli_marar_joggota++;
				if (helicopter[i].guli_marar_joggota > 100 && r.nextInt(100) == 0) {
					for (int j = 0; j < 10; j++) {
						if (!h_guli[j].visible) {
							h_guli[j] = new H_guli("run", helicopter[i].x + 50, helicopter[i].y + 50);
							break;
						}
					}

				}

			}
		}
	}

	private void bust_and_helicopter_colusion() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (helicopter[i].visible) {
				Rectangle rh = new Rectangle(helicopter[i].x, helicopter[i].y, 200, 60);
				for (int j = 0; j < 5; j++) {
					if (busts[j].visible) {
						for (int k = 0; k < 7; k++) {
							Rectangle rb = new Rectangle(busts[j].pos[k][0], busts[j].pos[k][1], Bust.bas, Bust.bas);

							if (rh.intersects(rb)) {
								helicopter[i].visible = false;
								helicopter[i].helicopter_sound.stop_helicopter_colar_sound();

								// helicopter er bisphoron sobdo hobe
								Helicopter_exp heli_exp = new Helicopter_exp("run");
								busts[j].vis[k] = false;
								Board.score += 200;
							}

						}
					}

				}

			}

		}
	}

	/*
	 * private void buster_position_change() { // TODO Auto-generated method
	 * stub for (int i = 0; i < 5; i++) { if (busts[i].visible)
	 * busts[i].change_position(); } }
	 */

	private void bust_designing(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			if (busts[i].visible)
				busts[i].draw_bust(g);
		}
	}

	private void points_and_mine_colusion() {

		Rectangle my_Rectangle = new Rectangle(Mine.x, Mine.y, 130, 50);
		Rectangle khabar;
		for (int i = 0; i < 5; i++) {
			if (points[i].visible) {
				khabar = new Rectangle(points[i].x, points[i].y, 50, 50);
				if (khabar.intersects(my_Rectangle)) {
					points[i].visible = false;
					Thread thread = new Thread(new Pointsexp("run"));
					kahabar_er_kaj_koro(i);
				}
			}
		}
	}

	private void kahabar_er_kaj_koro(int eto_tomo) {
		int n = points[eto_tomo].which_points;
		if (n == 0) // score barbe
			Board.score += 500;
		else if (n == 1) {
			if (life < 10) // life barbe
				life++;
			else
				score += 1000;
		}

		else if (n == 2) {
			// bust marbe
			for (int i = 0; i < 5; i++) {
				if (!busts[i].visible) {
					busts[i] = new Bust("run", eto_tomo);
					break;
				}
			}
		} else if (n == 3) {
			// uporer gulir sonkha barabe
			u_gulir_sonkha += 100;

		} else {
			// fronter gulir sonkha barabe
			f_gulir_sonkha += 100;
		}

	}

	private void points_er_position_change() {
		for (int i = 0; i < 5; i++) {
			if (points[i].visible)
				points[i].change_position();
		}
	}

	private void points_designing(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			if (points[i].visible)
				points[i].draw_paints(g);
		}
	}

	private void points_make_korbe_kina() {
		// TODO Auto-generated method stub
		if (p_er_counter > 100 && r.nextInt(1000) == 0) {
			p_er_counter = 0;
			for (int i = 0; i < 5; i++) {
				if (points[i].visible == false) {
					points[i] = new Points();
					break;
				}
			}
		}
	}

	private void upore_guli_and_helicopter_colusion() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (u_gulis[i].visible) {
				for (int j = 0; j < 10; j++) {
					if (helicopter[j].visible) {

						int c = helicopter[j].x - 50;
						int d = helicopter[j].y;
						Rectangle r1 = new Rectangle(c, d, 200, 60);

						int e = u_gulis[i].x;
						int f = u_gulis[i].y;
						Rectangle r2 = new Rectangle(e, f, 5, 20);

						if (r1.intersects(r2)) {
							helicopter[j].visible = false;
							helicopter[j].helicopter_sound.stop_helicopter_colar_sound();

							// helicopter er bisphoron sobdo hobe
							Helicopter_exp heli_exp = new Helicopter_exp("run");
							u_gulis[i].visible = false;
							score += 200;
						}
					}
				}
			}
		}
	}

	/*
	 * private void uporer_gulir_position_change() { // TODO Auto-generated
	 * method stub for (int i = 0; i < 10; i++) { if (u_gulis[i].visible) {
	 * u_gulis[i].change_position(); } } }
	 */

	private void uporer_guli_desing(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (u_gulis[i].visible) {
				u_gulis[i].draw_upore_guli(g);
			}
		}
	}

	private void upore_guli_charbe_kina() {
		// TODO Auto-generated method stub

		if ((upore_guli_bol || auto_u) && uporer_gulirr_jonno_counter > 50 && u_gulir_sonkha > 0) {
			uporer_gulirr_jonno_counter = 0;
			for (int i = 0; i < 10; i++) {
				if (u_gulis[i].visible == false) {
					u_gulis[i] = new Upore_guli("run");
					u_gulir_sonkha--;
					break;
				}
			}
		}
	}

	/*
	 * private void helicopter_position_change() { // TODO Auto-generated method
	 * stub for (int i = 0; i < 10; i++) { if (helicopter[i].visible) {
	 * helicopter[i].change_positon(); } } }
	 */
	private void helicopter_designing(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (helicopter[i].visible) {
				helicopter[i].draw_helicopter(g);
			}
		}
	}

	private void helicopter_make_korbe_kina() {
		// TODO Auto-generated method stub
		if (counter_helicopter > 210 && r.nextInt(100) == 0) {
			counter_helicopter = 0;
			for (int i = 0; i < 10; i++) {
				if (helicopter[i].visible == false) {
					helicopter[i] = new Helicopter("run");
					System.out.println("on kore charce bt choltace");
					// helicopter[i].helicopter_sound.helicopter_colar_sound();
					System.out.println("yes yes yes ");
					break;
				}
			}
		}
	}

	private void score_designing(Graphics g) {
		// TODO Auto-generated method stub

		String au_sped;
		if (Board.auto_running)
			au_sped = new String("ON");
		else
			au_sped = new String("OFF");

		String au_u;
		if (Board.auto_u)
			au_u = new String("ON");
		else
			au_u = new String("OFF");

		String au_f;
		if (Board.auto_f)
			au_f = new String("ON");
		else
			au_f = new String("OFF");

		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN + Font.ITALIC, 20));
		String faka = new String("      ");
		g.drawString("Life: " + String.valueOf(life) + faka + "Score: " + String.valueOf(score) + faka + "Auto-Speed: "
				+ au_sped + faka + "F_B: " + String.valueOf(f_gulir_sonkha) + faka + "U_B: "
				+ String.valueOf(u_gulir_sonkha) + faka + "A_F_B: " + au_f + faka + "A_F_B: " + au_u, 5, 20);
	}

	private void guli_and_oponents_er_colusion() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			if (gulis[i].visible) {
				for (int j = 0; j < 5; j++) {
					if (op[j].visible) {
						int ch = op[j].x;
						if (ch - 130 < gulis[i].x && gulis[i].x < ch) {
							op[j].visible = false;
							gulis[i].visible = false;
							gulis[i].gulir_sound.stop_gulir_sound();
							Car_exp car_exp = new Car_exp("run");
							score += 100;
						}
					}
				}
			}
		}

	}

	private void guli_charbe_kina() {
		// TODO Auto-generated method stub
		if ((samne_guli || auto_f) && gulirr_jonno_counter > 50 && f_gulir_sonkha > 0) {
			gulirr_jonno_counter = 0;
			for (int i = 0; i < 10; i++) {
				if (gulis[i].visible == false) {
					gulis[i] = new Guli("run");
					f_gulir_sonkha--;

					break;
				}
			}
		}
	}

	private void oponents_make_korbe_kina() {
		// TODO Auto-generated method stub

		// System.out.println("refresh counter: " + refresh_counter);
		if (refresh_counter > 100 && r.nextInt(100) == 0) {
			refresh_counter = 0;
			for (int i = 0; i < 5; i++) {
				if (op[i].visible == false) {
					op[i] = new Oponent("run");
					break;
				}
			}
		}

	}

	/*
	 * private void gulir_position_change() { // TODO Auto-generated method stub
	 * for (int i = 0; i < 10; i++) { if (gulis[i].visible)
	 * gulis[i].change_gulir_position(); } }
	 */

	/*
	 * private void oponents_car_position_change() { // TODO Auto-generated
	 * method stub for (int i = 0; i < 5; i++) { if (op[i].visible)
	 * op[i].change_car_position(); } }
	 */

	private void amar_guli_design(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.BLACK);
		for (int i = 0; i < 10; i++) {
			if (gulis[i].visible) {
				gulis[i].draw_guli(g);
			}
		}
	}

	private void ononent_car_and_wheel_design(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			if (op[i].visible) {
				op[i].oponent_car_designing(g);
				op[i].oponent_car_wheel_designing(g);
			}
		}
	}

	private void drawroad(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, Play.b - 100, Play.a, 80);
	}

	private void game_over_check() {
		// TODO Auto-generated method stub
		// opponents er jonno check -----------
		for (int i = 0; i < 5; i++) {
			if (op[i].visible && Mine.x + 123 > op[i].x) {
				gameover = true;
			}
		}

		// h_gulir jonno check---------------
		Rectangle mr = new Rectangle(Mine.x + 5, Mine.y + 5, 120, 50);
		Rectangle hr;
		for (int i = 0; i < 10; i++) {
			if (h_guli[i].visible) {
				hr = new Rectangle(h_guli[i].x, h_guli[i].y, H_guli.bas, H_guli.bas);
				if (hr.intersects(mr)) {
					if (life <= 0)
						gameover = true;
					else {
						life--;
						h_guli[i].visible = false;
					}
				}
			}
		}

	}

	public static void ghum() {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(ghumer_time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
