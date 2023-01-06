import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelSelect implements ActionListener {
    private JLabel title;
    private JButton level1;
    private JButton level2;
    private JButton level3;
    private JButton level4;
    private JButton back;
    private PageTemplate frame = new PageTemplate();
    private static int level;

    Border border = BorderFactory.createLineBorder(Color.BLACK);

    public LevelSelect(){
        title = new JLabel();
        title.setFont(new Font("Bernard", Font.PLAIN, 50));
        title.setText("S u r v i v o r");

        level1 = new JButton();
        level1.setFont(new Font("Bernard", Font.PLAIN, 20));
        level1.setText("Level 1");
        level1.addActionListener(this);

        level2 = new JButton();
        level2.setFont(new Font("Bernard", Font.PLAIN, 20));
        level2.setText("Level 2");
        level2.addActionListener(this);

        level3 = new JButton();
        level3.setFont(new Font("Bernard", Font.PLAIN, 20));
        level3.setText("Level 3");
        level3.addActionListener(this);

        level4 = new JButton();
        level4.setFont(new Font("Bernard", Font.PLAIN, 20));
        level4.setText("Level 4");
        level4.addActionListener(this);

        back = new JButton();
        back.setFont(new Font("Bernard", Font.PLAIN, 20));
        back.setText("Back");
        back.addActionListener(this);

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(340, 50, 320, 75);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title);

        JPanel level1Panel = new JPanel();
        level1Panel.setBounds(320, 150, 365, 50);
        level1Panel.setLayout(new BorderLayout());
        level1Panel.add(level1);

        JPanel level2Panel = new JPanel();
        level2Panel.setBounds(320, 250, 365, 50);
        level2Panel.setLayout(new BorderLayout());
        level2Panel.add(level2);

        JPanel level3Panel = new JPanel();
        level3Panel.setBounds(320, 350, 365, 50);
        level3Panel.setLayout(new BorderLayout());
        level3Panel.add(level3);

        JPanel level4Panel = new JPanel();
        level4Panel.setBounds(320, 450, 365, 50);
        level4Panel.setLayout(new BorderLayout());
        level4Panel.add(level4);

        JPanel exitPanel = new JPanel();
        exitPanel.setBounds(320, 550, 365, 50);
        exitPanel.setLayout(new BorderLayout());
        exitPanel.add(back);

        ImageIcon i = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Background.jpeg");
        JLabel bg = new JLabel(i);
        bg.setSize(1000,675);

        frame.add(titlePanel);
        frame.add(level1Panel);
        frame.add(level2Panel);
        frame.add(level3Panel);
        frame.add(level4Panel);
        frame.add(exitPanel);
        frame.add(bg);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == level1) {
            new Frame(1);
            frame.dispose();
        }else if (e.getSource() == level2) {
            new Frame(2);
            frame.dispose();
        }else if (e.getSource() == level3) {
            new Frame(3);
            frame.dispose();
        }else if (e.getSource() == level4) {
            new Frame(4);
            frame.dispose();
        }else if (e.getSource() == back) {
            MainMenu jf2 = new MainMenu();
            frame.dispose();
        }
    }    
}
