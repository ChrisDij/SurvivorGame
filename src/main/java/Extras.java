import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Extras implements ActionListener, ItemListener{
    private JLabel title;
    private JLabel mute;
    private JButton help;
    private JButton back;
    private PageTemplate frame = new PageTemplate();
    public static JCheckBox muteAlter;
    public static boolean answer = true;

    Border border = BorderFactory.createLineBorder(Color.BLACK);
    

    public Extras(){
        title = new JLabel();
        title.setFont(new Font("Bernard", Font.PLAIN, 50));
        title.setText("S u r v i v o r");

        mute = new JLabel();
        mute.setFont(new Font("Bernard", Font.PLAIN, 30));
        mute.setText("  Mute");

        help = new JButton();
        help.setFont(new Font("Bernard", Font.PLAIN, 20));
        help.setText("Help");
        help.addActionListener(this);

        muteAlter = new JCheckBox();
        muteAlter.setBounds(550, 200, 30, 75);
        muteAlter.setLayout(new BorderLayout());
        muteAlter.setBorder(border);
        muteAlter.setSelected(answer);
        muteAlter.addItemListener(frame);

        back = new JButton();
        back.setFont(new Font("Bernard", Font.PLAIN, 20));
        back.setText("Back");
        back.addActionListener(this);

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(340, 75, 320, 75);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title);

        JPanel mutePanel = new JPanel();
        mutePanel.setBounds(340, 200, 160, 75);
        mutePanel.setLayout(new BorderLayout());
        mutePanel.setBorder(border);
        mutePanel.add(mute);

        JPanel helpPanel = new JPanel();
        helpPanel.setBounds(340, 350, 320, 75);
        helpPanel.setLayout(new BorderLayout());
        helpPanel.add(help);

        JPanel backpanel = new JPanel();
        backpanel.setBounds(340, 525, 320, 75);
        backpanel.setLayout(new BorderLayout());
        backpanel.add(back);

        ImageIcon i = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Background.jpeg");
        JLabel bg = new JLabel(i);
        bg.setSize(1000,675);

        frame.add(titlePanel);
        frame.add(mutePanel);
        frame.add(helpPanel);
        frame.add(muteAlter);
        frame.add(backpanel);
        frame.add(bg);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == help) {
            HelpScreen jf2 = new HelpScreen();
            frame.dispose();
        } else if (e.getSource() == back) {
            MainMenu jf2 = new MainMenu();
            frame.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
