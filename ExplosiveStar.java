import java.awt.Graphics;

public class ExplosiveStar extends Star
{
    public static final double SPEED = .07;
    public static final int MAX_DISTANCE = 500;
    private int distanceTraveled = 0;
    public ExplosiveStar(Point _position, double _heading) 
    {
        super(_position, _heading);
    }
    public void paint(Graphics brush) {
        super.paint(brush, 10);
    }
    public boolean explosiveMove()
    {
        if (distanceTraveled < MAX_DISTANCE) {
            distanceTraveled++;
            super.move(SPEED, SPEED);
            return true;
        }
        else
        {
            return false;
        }
    }
}
