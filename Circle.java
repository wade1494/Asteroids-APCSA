import java.awt.Graphics;

public class Circle extends Shape
{
    public Circle(Point _postition, double _heading)
    {
        super(_postition, _heading);
    }
    public Point getPoint()
    {
        return this.position;
    }
    public double getHeading()
    {
        return this.heading;
    }
    public void setPoint(Point newPoint)
    {
        position  = newPoint;
    }
    public void setHeading(double newHeading)
    {
        heading = newHeading;
    }
    public void paint(Graphics brush, int diameter)
    {
        brush.fillOval((int)this.getPoint().x, (int)this.getPoint().y, diameter, diameter);
    }
    public void move(double xVelocity, double yVelocity) {
        this.getPoint().x += (xVelocity * Math.cos(Math.toRadians(this.getHeading())));
        this.getPoint().y += (yVelocity * Math.sin(Math.toRadians(this.getHeading())));
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
