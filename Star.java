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
        brush.fillOval((int)this.getPoint().x, (int)this.getPoint().y, 5, 5);
    }

    public void move() {
        this.getPoint().x += (0.01 * Math.cos(Math.toRadians(this.getHeading())));
        this.getPoint().y += (0.01 * Math.sin(Math.toRadians(this.getHeading())));
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
    }
}
