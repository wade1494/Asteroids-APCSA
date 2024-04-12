public class Circle 
{
    private Point position;
    private double heading;
    public Circle(Point _postition, double _heading)
    {
        this.position = _postition;
        this.heading = _heading;
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
}
