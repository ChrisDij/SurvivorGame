
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player {

    private int y, mx, my, bg1, right;
    public int x, spotx, spoty;
    private Image still;
    private static ArrayList bullets;
    private ImageIcon r = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Player.png");//Right
    private ImageIcon l = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Left.png");//Left

    public Player() {
        x = 0;
        y = 0;
        spotx = 299;//Controls the characters position
        spoty = 172;
        right = 4000;
        bg1 = 685;
        still = r.getImage();
        bullets = new ArrayList();
    }

    public void fire()//Method to run when fired
    {
        if (still.equals(r.getImage())) {
            Bullet z = new Bullet((spotx + 60), (spoty - 3));//Sets initial x and y coordinates of bullet
            bullets.add(z);
        }
        if (still.equals(l.getImage())) {
            Bullet z = new Bullet((spotx - 20), (spoty - 3));//Sets initial x and y coordinates of bullet
            bullets.add(z);
        }
    }

    public void move() {
// Left and Right
        if (x == 0 && spotx + mx > 0) {
            spotx += mx;// Moves the character
        }
        if (x == 3398 && spotx + mx < 600) {
            spotx += mx;
        }
        if (spotx == 300) {
            x += mx * 2;//Updates x axis
            bg1 += mx * 2;//Moves Background
        }
// Up and Down
        y += my;
        if (y > -178 && y < 404) {
            spoty += my;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getStill() {
        return still;
    }

    public ImageIcon getR() {
        return r;
    }

    public ImageIcon getL() {
        return l;
    }

    public int getnBG1() {
        return bg1;
    }

    public int getMX() {
        return mx;
    }

    public int getSPOTX() {
        return spotx;
    }

    public Image getImage() {
        return still;
    }

    public Rectangle getBounds() {
        return new Rectangle(spotx, spoty, 31, 8);
    }

    public static ArrayList getBullets() {
        return bullets;
    }//Hit Box

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            mx = -1;
            still = l.getImage();
        }
        if (key == KeyEvent.VK_D) {
            mx = 1;
            still = r.getImage();
        }
        if (key == KeyEvent.VK_S) {
            my = 1;
        }
        if (key == KeyEvent.VK_W) {
            my = -1;
        }
        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
        if (key == KeyEvent.VK_P) {

        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            mx = 0;
        }
        if (key == KeyEvent.VK_D) {
            mx = 0;
        }
        if (key == KeyEvent.VK_S) {
            my = 0;
        }
        if (key == KeyEvent.VK_W) {
            my = 0;
        }
    }
}
