import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.io.File;
import javax.sound.sampled.*;
/**
 * Klasa będąca pojemnikiem na wszystkie dźwięki gry
 */
public class SoundHolder {
	
	public SoundHolder(){
		
	}
	
	void playSound(String s){
		File sound = new File("src/main/resources/"+s+".wav");
		try {
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);

		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		
		clip.start();
		} catch (Exception e) {
		}
	}
	
}
