
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Scoreboard implements ActionListener {

    private JTable table;
    private JButton back;
    private PageTemplate frame = new PageTemplate();
    private String[] cols = {};
    private Connection conn = null;

    public Scoreboard() {

        //Creates a JTable in which the data cannot be edited or deleted
        String[] cols = {""};
        String[][] data = {{""}};
        table = new JTable(data, cols) {
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        String stmtSql = "SELECT TOP 10 GameTime, VolumeOn, [Level], Score, Age, Name FROM PlayerInfo ORDER BY Score DESC";
        table.setPreferredScrollableViewportSize(new Dimension(450, 63));
        table.setFillsViewportHeight(true);
        table.setModel(displayTable(stmtSql));
        JScrollPane scrollPane = new JScrollPane(table);

        back = new JButton();
        back.setFont(new Font("Bernard", Font.PLAIN, 20));
        back.setText("Back");
        back.addActionListener(this);

        JPanel tablepanel = new JPanel();
        tablepanel.setBounds(50, 10, 900, 500);
        tablepanel.setLayout(new BorderLayout());
        tablepanel.add(scrollPane);

        JPanel backpanel = new JPanel();
        backpanel.setBounds(340, 525, 320, 75);
        backpanel.setLayout(new BorderLayout());
        backpanel.add(back);

        ImageIcon i = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Background.jpeg");
        JLabel bg = new JLabel(i);
        bg.setSize(1000, 675);

        frame.add(tablepanel);
        frame.add(backpanel);
        frame.setVisible(true);
        frame.add(bg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            MainMenu jf2 = new MainMenu();
            frame.dispose();
        }
    }

    public DefaultTableModel displayTable(String sqlStatement) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Anuj/Documents/NetBeansProjects/SurvivorGame/SurvivorDatabase.accdb");
            java.sql.Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sqlStatement);

            ResultSetMetaData rsmd = rs.getMetaData();
            String[] columnNames = new String[rsmd.getColumnCount()];
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                columnNames[i] = rsmd.getColumnName(i + 1);
            }

            String[] columns = new String[]{"GameTime", "VolumeOn", "Level", "Score", "Age", "Name"};
            model.setColumnIdentifiers(columns);

            while (!rs.isLast()) {
                rs.next();

                Object[] temp = new Object[columnNames.length];
                temp[0] = rs.getTimestamp("GameTime").toString();
                temp[1] = new Boolean(rs.getBoolean("VolumeOn")).toString();
                temp[2] = new Integer(rs.getInt("Level")).toString();
                temp[3] = new Integer(rs.getInt("Score")).toString();
                temp[4] = new Integer(rs.getInt("Age")).toString();
                temp[5] = rs.getString("Name");

                model.addRow(temp);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "BAD SQL IS BAD\n\nCheck output window for possible errors");
        }
        return model;
    }
}
