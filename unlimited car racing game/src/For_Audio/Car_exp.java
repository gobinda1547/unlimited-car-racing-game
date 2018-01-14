package For_Audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class Car_exp extends JApplet implements Runnable {

	private AudioClip car_exp_file;
	public URL car_exp_sound;

	public Car_exp() {

		car_exp_sound = getClass().getResource("exp1.wav");
		car_exp_file = Applet.newAudioClip(car_exp_sound);

	}
	public Car_exp(String str) {

		car_exp_sound = getClass().getResource("exp1.wav");
		car_exp_file = Applet.newAudioClip(car_exp_sound);

		Thread sdss = new Thread(this);
		sdss.start();
	}


	public void run() {
		car_exp_file.play();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop_car_exp_sound();
	}

	public void stop_car_exp_sound() {
		if (car_exp_file != null)
			car_exp_file.stop();
	}

}
