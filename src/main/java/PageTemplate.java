
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PageTemplate extends JFrame implements ItemListener {

    private static Clip clip;

    public PageTemplate() {
        this.setLayout(null);
        this.setSize(1000, 675);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("S u r v i v o r");
        this.setFocusable(true);
    }

    public void itemStateChanged(ItemEvent e) {
        // if the state of checkbox1 is changed
        if (e.getSource() == Extras.muteAlter) {
            if (e.getStateChange() == 1) {
                this.playMusic(false);
            } else {
                clip.stop();
            }
        }
    }

    public void playMusic(boolean first) {
        try {
            File musicPath = new File("C:\\Users\\Anuj\\Documents\\NetBeansProjects\\SurvivorGame\\src\\main\\java\\Vngnc.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            long clipTimePosition = clip.getMicrosecondPosition();
            if (first == false) {
                if (musicPath.exists()) {
                    clip.open(audioInput);
                    clip.setMicrosecondPosition(clipTimePosition);
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
