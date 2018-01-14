package For_Audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

import designing.Board;

public class Car_sound extends JApplet implements Runnable {

	private AudioClip car_audio_file;
	public URL url_for_car_colar_sound;

	public Car_sound() {

		url_for_car_colar_sound = getClass().getResource("carrunning1.wav");
		car_audio_file = Applet.newAudioClip(url_for_car_colar_sound);
	}

	public Car_sound(String str) {

		url_for_car_colar_sound = getClass().getResource("carrunning1.wav");
		car_audio_file = Applet.newAudioClip(url_for_car_colar_sound);
		
		Thread th = new Thread(this);
		th.start();

	}

	public void run() {
		car_audio_file.loop();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop_car_colar_sound();

	}

	public void stop_car_colar_sound() {
		if (car_audio_file != null)
			car_audio_file.stop();
	}

}
