package For_Audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class Pointsexp extends JApplet implements Runnable {

	private AudioClip point_exp_file;
	public URL point_exp_sound;

	public Pointsexp() {

		point_exp_sound = getClass().getResource("bust.wav");
		point_exp_file = Applet.newAudioClip(point_exp_sound);

	}
	public Pointsexp(String str) {

		point_exp_sound = getClass().getResource("bust.wav");
		point_exp_file = Applet.newAudioClip(point_exp_sound);

		Thread aa = new Thread(this);
		aa.start();
	}

	public void run() {
		point_exp_file.play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop_point_exp_sound();
	}

	public void stop_point_exp_sound() {
		if (point_exp_file != null)
			point_exp_file.stop();
	}

}
