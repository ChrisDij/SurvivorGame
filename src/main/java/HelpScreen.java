
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpScreen implements ActionListener {

    private JButton lifeCycle;
    private JButton enemies;
    private JButton controls;
    private JButton userInterface;
    private JButton back;
    private JLabel content;
    private PageTemplate frame = new PageTemplate();
    private JPanel contentpanel;

    public HelpScreen() {

        lifeCycle = new JButton();
        lifeCycle.setFont(new Font("Bernard", Font.PLAIN, 20));
        lifeCycle.setText("Life Cycle");
        lifeCycle.addActionListener(this);

        enemies = new JButton();
        enemies.setFont(new Font("Bernard", Font.PLAIN, 20));
        enemies.setText("Enemies");
        enemies.addActionListener(this);

        controls = new JButton();
        controls.setFont(new Font("Bernard", Font.PLAIN, 20));
        controls.setText("Controls");
        controls.addActionListener(this);

        userInterface = new JButton();
        userInterface.setFont(new Font("Bernard", Font.PLAIN, 20));
        userInterface.setText("User Interface");
        userInterface.addActionListener(this);

        back = new JButton();
        back.setFont(new Font("Bernard", Font.PLAIN, 20));
        back.setText("Back");
        back.addActionListener(this);

        JPanel lifeCyclepanel = new JPanel();
        lifeCyclepanel.setBounds(50, 50, 240, 50);
        lifeCyclepanel.setLayout(new BorderLayout());
        lifeCyclepanel.add(lifeCycle);

        JPanel enemiespanel = new JPanel();
        enemiespanel.setBounds(50, 150, 240, 50);
        enemiespanel.setLayout(new BorderLayout());
        enemiespanel.add(enemies);

        JPanel controlspanel = new JPanel();
        controlspanel.setBounds(50, 350, 240, 50);
        controlspanel.setLayout(new BorderLayout());
        controlspanel.add(controls);

        JPanel userInterfacepanel = new JPanel();
        userInterfacepanel.setBounds(50, 450, 240, 50);
        userInterfacepanel.setLayout(new BorderLayout());
        userInterfacepanel.add(userInterface);

        JPanel backpanel = new JPanel();
        backpanel.setBounds(340, 525, 320, 75);
        backpanel.setLayout(new BorderLayout());
        backpanel.add(back);
        content = new JLabel();
        content.setBounds(100, 150, 700, 400);

        contentpanel = new JPanel();
        contentpanel.setBounds(350, 50, 600, 450);
        contentpanel.setLayout(new BorderLayout());
        contentpanel.setFont(new Font("Arial", Font.PLAIN, 20));
        contentpanel.add(content);

        JScrollPane scrollPane = new JScrollPane(content);
        contentpanel.add(scrollPane);

        ImageIcon i = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Background.jpeg");
        JLabel bg = new JLabel(i);
        bg.setSize(1000, 675);

        frame.add(lifeCyclepanel);
        frame.add(enemiespanel);
        frame.add(controlspanel);
        frame.add(userInterfacepanel);
        frame.add(backpanel);
        frame.add(content);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lifeCycle) {

            if (content != null) {
                content.remove(content);
            }
            content.setText("<html>The player dies when they touch an enemy ship. To prevent this outcome "
                    + "they must use their projectiles to destroy them first. If the player dies they will "
                    + "be taken to a game over screen</html> ");
            content.setBounds(350, 50, 600, 450);
            frame.add(content);

        } else if (e.getSource() == enemies) {
            if (content != null) {
                content.remove(content);
            }
            content.setText("<html>There are 4 types of enemies in this game. Each will go directly towards the player. They can be "
                    + " destroyed by using the SPACE key and firing a projectile at them. This projectile will destroy the "
                    + " oncoming enemy which will result in it respawning and go towards the player again.<br/></html> ");
            content.setBounds(350, 50, 600, 450);
            frame.add(content);

        } else if (e.getSource() == controls) {
            if (content != null) {
                content.remove(content);
            }
            content.setText("<html>W – Move character up"
                    + " A - Move character left"
                    + " S - Move character down"
                    + " D - Move character right"
                    + " SPACE – Shoot projectile<br/></html> ");
            content.setBounds(350, 50, 600, 450);
            frame.add(content);
        } else if (e.getSource() == userInterface) {
            if (content != null) {
                content.remove(content);
            }
            content.setText("<html>The player will begin the game at the main menu frame. This frame contains routes to 3 other "
                    + "frames. This being the level select frame in which the player can select levels. The scoreboard frame "
                    + "in which they can see the scores of previous players. The extras class which contains extra "
                    + "information on the program as well as an option to mute audio and there is also an option to exit the "
                    + "program from the main menu frame. Level select will allow the player to play the primary game. "
                    + "Once the player dies they will be taken to a game over screen in which they must insert their "
                    + "username and age. <br/></html> ");
            content.setBounds(350, 50, 600, 450);
            frame.add(content);
        } else if (e.getSource() == back) {
            MainMenu jf2 = new MainMenu();
            frame.dispose();
        }
    }
}
