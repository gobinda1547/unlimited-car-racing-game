package For_Audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class Upore_gulir_sound extends JApplet implements Runnable {

	private AudioClip gulir_audio_file;
	public URL url_for_gulir_sound;

	public Upore_gulir_sound() {

		url_for_gulir_sound = getClass().getResource("pistol.wav");
		gulir_audio_file = Applet.newAudioClip(url_for_gulir_sound);

	}

	public Upore_gulir_sound(String str) {

		url_for_gulir_sound = getClass().getResource("pistol.wav");
		gulir_audio_file = Applet.newAudioClip(url_for_gulir_sound);
		Thread gg = new Thread(this);
		gg.start();
	}

	public void run() {
		gulir_audio_file.play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop_upore_gulir_sound();

	}

	public void stop_upore_gulir_sound() {
		if (gulir_audio_file != null)
			gulir_audio_file.stop();
	}

}
