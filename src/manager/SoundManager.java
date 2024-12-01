package manager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SoundManager {

    private Clip background;
    private long clipTime = 0;
    private FloatControl backgroundControl;
    private List<Clip> activeClips; // List to hold active sound clips
    private float currentVolume = -20.0f; // Default volume for sound effects

    public SoundManager() {
        activeClips = new ArrayList<>(); // Initialize the list
        background = getClip(loadAudio("background"));
        if (background != null) {
            backgroundControl = (FloatControl) background.getControl(FloatControl.Type.MASTER_GAIN);
        }
    }

    private AudioInputStream loadAudio(String url) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream("/media/audio/" + url + ".wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            return AudioSystem.getAudioInputStream(bufferedIn);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private Clip getClip(AudioInputStream stream) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            activeClips.add(clip); // Add the clip to the active list
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setVolume(float volume) {
        float gain = Math.max(-80.0f, Math.min(6.0f, volume));
        currentVolume = gain; // Store the current volume level

        // Set volume for background clip
        if (backgroundControl != null) {
            backgroundControl.setValue(gain);
        }

        // Set volume for all active clips
        for (Clip clip : activeClips) {
            FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            if (control != null) {
                control.setValue(gain);
            }
        }
    }

    public void resumeBackground() {
        background.setMicrosecondPosition(clipTime);
        background.start();
    }

    public void pauseBackground() {
        clipTime = background.getMicrosecondPosition();
        background.stop();
    }

    public void restartBackground() {
        clipTime = 0;
        resumeBackground();
    }

    public void playJump() {
        playSound("jump");
    }

    public void playCoin() {
        playSound("coin");
    }

    public void playFireball() {
        playSound("fireball");
    }

    public void playGameOver() {
        playSound("gameOver");
    }

    public void playStomp() {
        playSound("stomp");
    }

    public void playOneUp() {
        playSound("oneUp");
    }

    public void playSuperMushroom() {
        playSound("superMushroom");
    }

    public void playMarioDies() {
        playSound("marioDies");
    }

    public void playFireFlower() {
        playSound("fireFlower");
    }

    private void playSound(String sound) {
        AudioInputStream audioStream = loadAudio(sound);
        if (audioStream != null) {
            Clip clip = getClip(audioStream);
            if (clip != null) {
                // Set the volume for the newly created clip
                FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                if (control != null) {
                    control.setValue(currentVolume); // Use the stored volume level
                }
                clip.start();
            }
        }
    }
}