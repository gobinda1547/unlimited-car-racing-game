package For_Audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

import designing.Board;

public class Helicopter_sound extends JApplet implements Runnable{

	private AudioClip helicopter_audio_file;
	public URL url_for_helicopter_colar_sound;

	public Helicopter_sound() {

		url_for_helicopter_colar_sound = getClass().getResource(
				"helicopter5.wav");
		helicopter_audio_file = Applet
				.newAudioClip(url_for_helicopter_colar_sound);
	}

	public Helicopter_sound(String str) {

		url_for_helicopter_colar_sound = getClass().getResource(
				"helicopter5.wav");
		helicopter_audio_file = Applet
				.newAudioClip(url_for_helicopter_colar_sound);
		
		Thread gpThread = new Thread(this);
		gpThread.start();
	}

	public void run() {
		helicopter_audio_file.loop();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop_helicopter_colar_sound();

	}

	public void stop_helicopter_colar_sound() {
		if (helicopter_audio_file != null)
			helicopter_audio_file.stop();
	}

}
