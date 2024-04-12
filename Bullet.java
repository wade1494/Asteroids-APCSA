/*
CLASS: Bullet
DESCRIPTION: Represents Bullet (weapon)
NOTE: move() in this class returns a boolean, note the BULLET_SPEED and MAX_DISTANCE
*/

import java.awt.*;
public class Bullet extends Circle
{
    public static final double BULLET_SPEED = .3;
    public static final int MAX_DISTANCE = 2000;
    private int distanceTraveled = 0;
    public Bullet(Point _position, double _heading) {
        super(_position, _heading);
    }

    public void paint(Graphics brush) {
        brush.setColor(Color.white);
        brush.fillOval((int)this.getPoint().x, (int)this.getPoint().y, 20, 20);
    }

    public boolean move() {
        if (distanceTraveled < MAX_DISTANCE) {
            distanceTraveled++;
            this.getPoint().x += (BULLET_SPEED * Math.cos(Math.toRadians(this.getHeading())));
            this.getPoint().y += (BULLET_SPEED * Math.sin(Math.toRadians(this.getHeading())));
            if (this.getPoint().x > 800) {
                this.getPoint().x = 0;
            }
            if (this.getPoint().x < 0) {
                this.getPoint().x = 800;
            }
            if (this.getPoint().y > 600) {
                this.getPoint().y = 0;
            }
            if (this.getPoint().y < 0) {
                this.getPoint().y = 600;
            }
            return true;
        } else {
            return false;
        }
    }
}
