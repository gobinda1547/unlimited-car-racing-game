package For_Audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class Helicopter_exp extends JApplet implements Runnable {

	private AudioClip helicopter_exp_file;
	public URL helicopter_exp_sound;

	public Helicopter_exp() {

		helicopter_exp_sound = getClass().getResource("exp1.wav");
		helicopter_exp_file = Applet.newAudioClip(helicopter_exp_sound);

	}

	public Helicopter_exp(String str) {

		helicopter_exp_sound = getClass().getResource("exp1.wav");
		helicopter_exp_file = Applet.newAudioClip(helicopter_exp_sound);

		Thread ths = new Thread(this);
		ths.start();
	}


	public void run() {
		helicopter_exp_file.play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop_helicopter_exp_sound();
	}

	public void stop_helicopter_exp_sound() {
		if (helicopter_exp_file != null)
			helicopter_exp_file.stop();
	}

}
