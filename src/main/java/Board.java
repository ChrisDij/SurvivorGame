
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    public static Player p = new Player();
    public Image img;
    private Timer time;
    private Enemy en;
    private Enemy en2;
    private boolean lost = false; //if the game is over
    private static int lives,level, score;
    private String enemyLink;


    static Font font = new Font("SanSerif", Font.BOLD, 24);

    public Board(int lvl) {
        level = lvl;
        addKeyListener(new AL());
        setFocusable(true);
        System.out.println(level);
        if (level == 1){
        enemyLink = "C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Chomper.png";
        }if (level == 2){
        enemyLink = "C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Fighter.png";
        }if (level == 3){
        enemyLink = "C:\\Users\\Anuj\\Documents\\NetBeansProjects\\SurvivorGame\\src\\main\\java\\Models\\Diver.png";
        }if (level == 4){
        enemyLink = "C:\\Users\\Anuj\\Documents\\NetBeansProjects\\SurvivorGame\\src\\main\\java\\Models\\UFO.png";
        }
        en = new Enemy(700, 200, enemyLink);
        en2 = new Enemy(700, 200, enemyLink);
         

        ImageIcon i = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Background.jpeg");
        img = i.getImage();
        time = new Timer(5, this);
        time.start();
        lives = 1;
    }

    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        ArrayList bullets = Player.getBullets();
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = (Bullet) bullets.get(i);//draw:
            if (bullet.getVisible() == true) {
                bullet.move();
            } else {
                bullets.remove(i);
            }
        }

        p.move();

        if (p.x > 400) {
            en.move(p.getMX(), p.getSPOTX());
        }
        if (p.x > 500) {
            en2.move(p.getMX(), p.getSPOTX());
        }
        repaint();//Repaints the image every 5 milliseconds
    }

    public void paint(Graphics g) {
        if (lost) {
            lives = lives - 1;
            if (lives == 0) {
                GameEnd jf2 = new GameEnd(level, score);
                //Frame.frame.dispose();

            }
        }
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 685 - p.getnBG1(), 0, null);//Background
        g2d.drawImage(p.getImage(), p.spotx, p.spoty, null);//Player
        ArrayList bullets = Player.getBullets();

        if (p.getStill() == (p.getImage())) {
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = (Bullet) bullets.get(i);//draw:
                if (bullet.getVisible()) {
                    g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
                }
            }
        }
        if (p.getStill() != (p.getImage())) {
            for (int i = 0; i > bullets.size(); i--) {
                Bullet bullet = (Bullet) bullets.get(i);//draw:
                if (bullet.getVisible()) {
                    g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
                }
            }
        }
        if (en.Alive() == true) {
            g2d.drawImage(en.getImage(), en.getX(), en.getY(), null);
        }
        if (en2.Alive() == true) {
            g2d.drawImage(en2.getImage(), en2.getX(), en2.getY(), null);
        }
    }

    public void checkCollisions() {
        Rectangle r1 = en.getBounds(); //Creates hit boxes for enemies
        Rectangle r2 = en2.getBounds();
        ArrayList bullets = Player.getBullets();
        for (int i = 0; i < bullets.size(); i++) {
            Bullet m = (Bullet) bullets.get(i);
            Rectangle m1 = m.getBounds();
            if (r1.intersects(m1) && en.Alive()) {
                en.isAlive = false;
                m.visible = false;
                en = new Enemy(700, 200, enemyLink);
                score = score + 1000;
            }
            if (r2.intersects(m1) && en2.Alive()) {
                en2.isAlive = false;
                m.visible = false;
                en2 = new Enemy(700, 200, enemyLink);
                score = score + 1000;
            }
        }
        Rectangle d = p.getBounds();
        if (d.intersects(r1) || d.intersects(r2)) {
            lost = true;
        }
    }

    private class AL extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
    }
}
