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

    public void paint(Graphics brush, int diameter) {
        brush.setColor(Color.white);
        super.paint(brush, diameter);
    }

    public boolean bulletMove() 
    {
        if (distanceTraveled < MAX_DISTANCE) {
            distanceTraveled++;
            super.move(0.1, 0.1);
            return true;
        }
        else
        {
            return false;
        }
    }
}
