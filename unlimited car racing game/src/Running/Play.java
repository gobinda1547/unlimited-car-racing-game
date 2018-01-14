package Running;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;

import For_game_over.Game_over;

import designing.Board;

public class Play {

	public static int a = 950, b = 600;

	public static Board board = new Board();

	public static JFrame frame, gameover_frame;

	public static void main(String[] args) {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		a = dim.width;
		b = dim.height;

		game_over_frame_making();

		game_main_panel();

		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (board.gameover) {
					System.exit(-1);
				} else {
					if (e.getButton() == MouseEvent.BUTTON1) {
						board.samne_guli = false;
					}
					if (e.getButton() == MouseEvent.BUTTON3) {
						board.upore_guli_bol = false;
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (board.gameover) {
					System.exit(-1);
				} else {

					if (e.getButton() == MouseEvent.BUTTON1) {
						board.samne_guli = true;
					}
					if (e.getButton() == MouseEvent.BUTTON3) {
						board.upore_guli_bol = true;
					}
				}

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getX() + "    " + e.getY());
			}
		});

		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					board.mine.piche = false;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					board.mine.samne = false;
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					board.samne_guli = false;
				if (e.getKeyCode() == KeyEvent.VK_UP)
					board.upore_guli_bol = false;

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					board.mine.piche = true;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					board.mine.samne = true;
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					board.samne_guli = true;
				if (e.getKeyCode() == KeyEvent.VK_UP)
					board.upore_guli_bol = true;

				if (e.getKeyCode() == KeyEvent.VK_A) {
					if (Board.auto_running)
						Board.auto_running = false;
					else
						Board.auto_running = true;
				}

				if (e.getKeyCode() == KeyEvent.VK_F) {
					if (Board.auto_f)
						Board.auto_f = false;
					else
						Board.auto_f = true;
				}

				if (e.getKeyCode() == KeyEvent.VK_U) {
					if (Board.auto_u)
						Board.auto_u = false;
					else
						Board.auto_u = true;
				}

			}
		});

	}

	private static void game_main_panel() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(a, b);

		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(1, 1));
		frame.add(board);
	}

	private static void game_over_frame_making() {
		// TODO Auto-generated method stub
		gameover_frame = new JFrame();
		gameover_frame.setVisible(false);
		gameover_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameover_frame.setSize(a, b);
		gameover_frame.setLocationRelativeTo(null);
		gameover_frame.setLayout(new GridLayout(1, 1));

		Game_over game_over = new Game_over();
		gameover_frame.add(game_over);
	}

}
