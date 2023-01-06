
import java.awt.*;
import javax.swing.ImageIcon;

public class Enemy {

    Image img;
    int x, y;
    boolean isAlive = true;

    public Enemy(int startX, int startY, String location) {
        x = startX;
        y = startY;
        ImageIcon l = new ImageIcon(location);
        img = l.getImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 31, 8);
    }//Hit Box

    public int getX() {

        if (x < Board.p.spotx + 50 || x > Board.p.spotx - 50) {
            if (x <= Board.p.spotx) {
                x = x + 1;
            }
            if (x >= Board.p.spotx) {
                x = x - 1;
            }
        }
        return x;
    }

    public int getY() {
        if (y < Board.p.spoty + 50 || y > Board.p.spoty - 50) {
            if (y <= Board.p.spoty) {
                y = y + 1;
            }
            if (y >= Board.p.spoty) {
                y = y - 1;
            }
        }
        return y;
    }

    public boolean Alive() {
        return isAlive;
    }

    public Image getImage() {
        return img;
    }

    public void move(int dx, int left) {
        if (dx == 1 && !((left + dx) < 150))//Added this to only move enemy when character moves forward (not back)
        {
            x = x - dx;
        }
    }
}
