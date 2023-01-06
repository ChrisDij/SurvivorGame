
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MainMenu implements ActionListener {

    private JLabel title;
    private JButton start;
    private JButton score;
    private JButton extras;
    private JButton exit;
    private PageTemplate frame = new PageTemplate();
    public static boolean alreadyExecuted = false;

    public MainMenu() {

        if (!alreadyExecuted) {
            frame.playMusic(alreadyExecuted);
            alreadyExecuted = true;
        }

        title = new JLabel();
        title.setFont(new Font("Bernard", Font.PLAIN, 50));
        title.setText("S u r v i v o r");

        start = new JButton();
        start.setFont(new Font("Bernard", Font.PLAIN, 20));
        start.setText("Start");
        start.addActionListener(this);

        score = new JButton();
        score.setFont(new Font("Bernard", Font.PLAIN, 20));
        score.setText("Scoreboard");
        score.addActionListener(this);

        extras = new JButton();
        extras.setFont(new Font("Bernard", Font.PLAIN, 20));
        extras.setText("Extras");
        extras.addActionListener(this);

        exit = new JButton();
        exit.setFont(new Font("Bernard", Font.PLAIN, 20));
        exit.setText("Exit");
        exit.addActionListener(this);

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(340, 75, 320, 75);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title);

        JPanel startPanel = new JPanel();
        startPanel.setBounds(320, 250, 365, 50);
        startPanel.setLayout(new BorderLayout());
        startPanel.add(start);

        JPanel scorePanel = new JPanel();
        scorePanel.setBounds(320, 350, 365, 50);
        scorePanel.setLayout(new BorderLayout());
        scorePanel.add(score);

        JPanel extrasPanel = new JPanel();
        extrasPanel.setBounds(320, 450, 365, 50);
        extrasPanel.setLayout(new BorderLayout());
        extrasPanel.add(extras);

        JPanel exitPanel = new JPanel();
        exitPanel.setBounds(320, 550, 365, 50);
        exitPanel.setLayout(new BorderLayout());
        exitPanel.add(exit);

        ImageIcon i = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Background.jpeg");

        JLabel bg = new JLabel(i);
        bg.setSize(1000, 675);

        frame.add(titlePanel);
        frame.add(startPanel);
        frame.add(scorePanel);
        frame.add(extrasPanel);
        frame.add(exitPanel);
        frame.add(bg);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu l = new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            LevelSelect jf2 = new LevelSelect();
            frame.dispose();
        } else if (e.getSource() == extras) {
            Extras jf2 = new Extras();
            frame.dispose();
        } else if (e.getSource() == score) {
            Scoreboard jf2 = new Scoreboard();
            frame.dispose();
        } else if (e.getSource() == exit) {
            System.exit(1);
        }
    }
}
