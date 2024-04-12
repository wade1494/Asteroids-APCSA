/*
CLASS: Star
DESCRIPTION: Represents Star (non-interactive background object)
NOTE: move() in this class returns a boolean, note the BULLET_SPEED and MAX_DISTANCE
*/

import java.awt.*;
public class Star extends Circle
{
    public Star(Point _position, double _heading) {
        super(_position, _heading);
    }

    public void paint(Graphics brush) {
        super.paint(brush, 5);
    }

    public void move() {
        super.move(0.1, 0.1);
    }
}
