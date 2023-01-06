
import java.awt.*;
import javax.swing.*;

public class Bullet {

    private int x, y;//-- Controls the CURRENT location of THIS bullet
    //Each object of this class is a new BULLET
    private Image nb, nbb;
    public boolean visible;
    private Player p = new Player();

    public Bullet(int startX, int startY) {
        ImageIcon newBullet = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Bullet.png");
        ImageIcon newBackBullet = new ImageIcon("C:\\Users\\Anuj\\Desktop\\SurvivorGame\\src\\Models\\Bullet.png");
        nb = newBullet.getImage();
        nbb = newBackBullet.getImage();
        x = startX;
        y = startY;
        visible = true;

    }

    public void move() {
        x += 2; //x + bullet speed
        if (x > 700) {// if x > board width
            //Make the bullet invisible
            visible = false;
        }
    }

    public int getX() {
        return x;
    }

    public boolean getVisible() {
        return visible;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return nb;
    }

    public Image getBackImage() {
        return nbb;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 44, 24);
    }//Hit Box
}
