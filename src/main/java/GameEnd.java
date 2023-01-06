
import javax.swing.*;
import java.awt.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class GameEnd implements ActionListener {

    private JTable table;
    private JButton back;
    private JTextField name, age;
    private PageTemplate frame = new PageTemplate();
    private String fileName = "C:\\Users\\Anuj\\Documents\\NetBeansProjects\\SurvivorGame\\src\\main\\java\\Table.txt";
    private int level, score;
    private Date todaysDate = new Date();

    public GameEnd(int l, int s) {

        score = s;
        level = l;
        //Creates a JTable in which the data cannot be edited or deleted
        String[] cols = {""};
        String[][] data = {{""}};
        table = new JTable(data, cols) {
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        String stmtSql = "SELECT GameTime, VolumeOn, Level, Score, Age, Name FROM PlayerInfo ORDER BY Score DESC";
        table.setPreferredScrollableViewportSize(new Dimension(450, 63));
        table.setFillsViewportHeight(true);
        table.setModel(displayTable(stmtSql));
        JScrollPane scrollPane = new JScrollPane(table);

        back = new JButton();
        back.setFont(new Font("Bernard", Font.PLAIN, 20));
        back.setText("Back");
        back.addActionListener(this);

        name = new JTextField();
        name.setDocument(new JTextFieldLimit(3));
        name.setFont(new Font("Bernard", Font.PLAIN, 20));
        name.addActionListener(this);

        age = new JTextField();
        age.setDocument(new JTextFieldLimit(2));
        age.setFont(new Font("Bernard", Font.PLAIN, 20));
        age.addActionListener(this);

        JPanel tablepanel = new JPanel();
        tablepanel.setBounds(50, 10, 900, 500);
        tablepanel.setLayout(new BorderLayout());
        tablepanel.add(scrollPane);

        JPanel backpanel = new JPanel();
        backpanel.setBounds(50, 525, 320, 75);
        backpanel.setLayout(new BorderLayout());
        backpanel.add(back);

        JLabel giveName = new JLabel();
        giveName.setFont(new Font("Bernard", Font.PLAIN, 20));
        giveName.setText("Insert player name:");

        JPanel giveNamepanel = new JPanel();
        giveNamepanel.setBounds(420, 525, 180, 75);
        giveNamepanel.setLayout(new BorderLayout());
        giveNamepanel.add(giveName);

        JPanel namepanel = new JPanel();
        namepanel.setBounds(620, 525, 50, 75);
        namepanel.setLayout(new BorderLayout());
        namepanel.add(name);

        JLabel giveAge = new JLabel();
        giveAge.setFont(new Font("Bernard", Font.PLAIN, 20));
        giveAge.setText("Insert player age:");

        JPanel giveAgepanel = new JPanel();
        giveAgepanel.setBounds(725, 525, 160, 75);
        giveAgepanel.setLayout(new BorderLayout());
        giveAgepanel.add(giveAge);

        JPanel agepanel = new JPanel();
        agepanel.setBounds(900, 525, 50, 75);
        agepanel.setLayout(new BorderLayout());
        agepanel.add(age);

        ImageIcon i = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Background.jpeg");
        JLabel bg = new JLabel(i);
        bg.setSize(1000, 675);

        frame.add(tablepanel);
        frame.add(namepanel);
        frame.add(backpanel);
        frame.add(giveNamepanel);
        frame.add(agepanel);
        frame.add(giveAgepanel);
        frame.setVisible(true);
        frame.add(bg);

        //System.out.println(b.getScore());
    }

    public class JTextFieldLimit extends PlainDocument {

        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }
            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {

            Connection conn = null;
            Statement stmt = null;

            try {
                conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Anuj/Documents/NetBeansProjects/SurvivorGame/SurvivorDatabase.accdb");

                stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

                ResultSet uprs = stmt.executeQuery(
                        "SELECT GameTime, VolumeOn, Level, Score, Age, Name FROM PlayerInfo");

                uprs.moveToInsertRow();
                Timestamp ts = new Timestamp(System.currentTimeMillis());

                uprs.updateTimestamp("GameTime", ts);
                uprs.updateBoolean("VolumeOn", Extras.answer);
                uprs.updateInt("Level", level);
                uprs.updateInt("Score", score);
                uprs.updateInt("Age", Integer.parseInt(age.getText()));
                uprs.updateString("Name", name.getText());

                uprs.insertRow();
                uprs.beforeFirst();

                System.out.println("Inser SQL here");
            } catch (SQLException se) {

            } finally {
                if (conn != null)try {
                    conn.close();
                    if (stmt != null) {
                        stmt.close();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(GameEnd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

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
