
public abstract class Shape {
    protected Point position;
    protected double heading;

    public Shape(Point _position, double _heading) {
        this.position = _position;
        this.heading = _heading;
    }

    public Point getPosition() {
        return position;
    }

    public double getHeading() {
        return heading;
    }
    public void setPosition(Point newPosition)
    {
        this.position = newPosition;
    }
    public void setHeading(double newHeading) {
        this.heading = newHeading;
    }
    public void move(double velocity) {
        move(velocity, velocity);
    }
    public void move(double xVelocity, double yVelocity) {
        this.position.x += (xVelocity * Math.cos(Math.toRadians(this.heading)));
        this.position.y += (yVelocity * Math.sin(Math.toRadians(this.heading)));
    }    
}
