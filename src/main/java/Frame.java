
import javax.swing.*;

public class Frame {

    private JFrame frame = new JFrame();

    public Frame(int lvl) {
        frame.add(new Board(lvl));
        frame.setTitle("S u r v i v o r");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 660);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
