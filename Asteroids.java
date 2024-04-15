/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
*/
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Timer;
public class Asteroids extends Game {
    // Game state variables and objects
    
    private Ship ship;
    private int shipHealth = 3;
    private Bullet bullet1;
    private Bullet bullet2;
    private Timer collisionTimer;
    private Timer spawnTimer;
    private ArrayList<Asteroid> asteroids;
    private ArrayList<Star> stars;
    private boolean turningLeft;
    private boolean turningRight;
    private boolean accelerating;
    private boolean damageApplied;
    private ArrayList<Asteroid> smallerAsteroidList = new ArrayList<>();
    private ArrayList<ExplosiveStar> explosive = new ArrayList<>();
    public void damageTimer() 
    {
        collisionTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                damageApplied = false;
            }
        });
    }
    
    public Asteroids() 
    {    
        // Call the Game constructor to create a new "Asteroids!" window that is 800 x 600 pixels
        super("Asteroids!", 800, 600);
        // Don't worry about this...
        this.setFocusable(true);
        damageTimer();
        asteroidSpawner();
        // Define the set of points for the ship and draw it in the middle of the canvas
        Point[] shipPoints = { 
            new Point(0, 0), 
            new Point(35, 10), 
            new Point(0, 20), 
            new Point(5, 10) 
        };
        
        ship = new Ship(shipPoints, new Point(300, 300), 0);
        // This draws each asteroid as a perfect hexagon.
        //4 different shape asteroid
        Point[] asteroidPoints1 = {
            new Point(18, 6),
            new Point(36, 18),
            new Point(30, 42),
            new Point(12, 36),
            new Point(0, 18)
        };
        
        Point[] asteroidPoints2 = {
            new Point(12, 0),
            new Point(30, 12),
            new Point(24, 36),
            new Point(6, 30),
            new Point(0, 12)
        };
        
        Point[] asteroidPoints3 = {
            new Point(6, 0),
            new Point(30, 18),
            new Point(18, 42),
            new Point(0, 30),
            new Point(0, 6)
        };
        
        Point[] asteroidPoints4 = {
            new Point(0, 0),
            new Point(24, 12),
            new Point(12, 36),
            new Point(6, 24),
            new Point(0, 12)
        };
        
        
        Point[] asteroidSpawnPoints = {
            new Point(100, 100),
            new Point(200, 200),
            new Point(400, 400),
            new Point(500, 500),
            new Point(600, 100),
            new Point(700, 200),
            new Point(800, 300),
            new Point(100, 500),
            new Point(200, 400),
            new Point(400, 100),
            new Point(500, 600),
            new Point(600, 300),
            new Point(700, 400),
            new Point(800, 200)
        };

        Asteroid[] array = new Asteroid[8];
        for (int i = 0; i < array.length; i++)
        {
            Point[] asteroidPoints;
            int randomSpawn = (int) (Math.random() * asteroidSpawnPoints.length);
            Point spawnPoint = asteroidSpawnPoints[randomSpawn];
            asteroidSpawnPoints[randomSpawn] = null;
            int randomIndex = (int) (Math.random() * 4);
            if (randomIndex == 0)
            {
                asteroidPoints = asteroidPoints1;
            }
            else if (randomIndex == 1)
            {
                asteroidPoints = asteroidPoints2;
            }
            else if (randomIndex == 2)
            {
                asteroidPoints = asteroidPoints3;
            }
            else if (randomIndex == 3)
            {
                asteroidPoints = asteroidPoints4;
            }
            else 
            {
                asteroidPoints = asteroidPoints1;
            }
            while (spawnPoint == null)
            {
                randomSpawn = (int) (Math.random() * asteroidSpawnPoints.length);
                spawnPoint = asteroidSpawnPoints[randomSpawn];
            }
            array[i] = new Asteroid(asteroidPoints, spawnPoint, Math.random() * 360);
            asteroidSpawnPoints[randomSpawn] = null;
        }
            // Add more asteroids here
        asteroids = new ArrayList<Asteroid>(Arrays.asList(array));

        // Create two new star objects with random coordinates on the canvas and with random headings
        // so they can move in random directions.
        stars = new ArrayList<Star>();
        for (int i = 0; i < 100; i++)
        {
            stars.add(new Star(new Point(Math.random() * 800, Math.random() * 600), Math.random() * 360));
        }

        this.addKeyListener(new Keyboard());
    }
public void asteroidSpawner()
        {
            Point[] asteroidPoints1 = {
                new Point(18, 6),
                new Point(36, 18),
                new Point(30, 42),
                new Point(12, 36),
                new Point(0, 18)
            };
            
            Point[] asteroidPoints2 = {
                new Point(12, 0),
                new Point(30, 12),
                new Point(24, 36),
                new Point(6, 30),
                new Point(0, 12)
            };
            
            Point[] asteroidPoints3 = {
                new Point(6, 0),
                new Point(30, 18),
                new Point(18, 42),
                new Point(0, 30),
                new Point(0, 6)
            };
            
            Point[] asteroidPoints4 = {
                new Point(0, 0),
                new Point(24, 12),
                new Point(12, 36),
                new Point(6, 24),
                new Point(0, 12)
            };
            
            
            Point[] asteroidSpawnPoints = {
                new Point(100, 100),
                new Point(200, 200),
                new Point(400, 400),
                new Point(500, 500),
                new Point(600, 100),
                new Point(700, 200),
                new Point(800, 300),
                new Point(100, 500),
                new Point(200, 400),
                new Point(400, 100),
                new Point(500, 600),
                new Point(600, 300),
                new Point(700, 400),
                new Point(800, 200)
            };
            spawnTimer = new Timer(10000, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    System.out.println("Spawning");
                    Point[] asteroidPoints;
                    int randomSpawn = (int) (Math.random() * asteroidSpawnPoints.length);
                    Point spawnPoint = asteroidSpawnPoints[randomSpawn];
                    asteroidSpawnPoints[randomSpawn] = null;
                    int randomIndex = (int) (Math.random() * 4);
                    if (randomIndex == 0)
                    {
                        asteroidPoints = asteroidPoints1;
                    }
                    else if (randomIndex == 1)
                    {
                        asteroidPoints = asteroidPoints2;
                    }
                    else if (randomIndex == 2)
                    {
                        asteroidPoints = asteroidPoints3;
                    }
                    else if (randomIndex == 3)
                    {
                        asteroidPoints = asteroidPoints4;
                    }
                    else 
                    {
                        asteroidPoints = asteroidPoints1;
                    }
                    while (spawnPoint == null)
                    {
                        randomSpawn = (int) (Math.random() * asteroidSpawnPoints.length);
                        spawnPoint = asteroidSpawnPoints[randomSpawn];
                    }
                    asteroids.add(new Asteroid(asteroidPoints, spawnPoint, Math.random() * 360));
                    asteroidSpawnPoints[randomSpawn] = null;
                }
            });
            spawnTimer.start();
        }
        
    public void restartGame()
    {
        shipHealth = 3;
        this.play = true;
        Point[] shipPoints = { 
            new Point(0, 0), 
            new Point(35, 10), 
            new Point(0, 20), 
            new Point(5, 10) 
        };
        ship = new Ship(shipPoints, new Point(300, 300), 0);

        // This draws each asteroid as a perfect hexagon.
        //4 different shape asteroid
        Point[] asteroidPoints1 = {
            new Point(18, 6),
            new Point(36, 18),
            new Point(30, 42),
            new Point(12, 36),
            new Point(0, 18)
        };
        
        Point[] asteroidPoints2 = {
            new Point(12, 0),
            new Point(30, 12),
            new Point(24, 36),
            new Point(6, 30),
            new Point(0, 12)
        };
        
        Point[] asteroidPoints3 = {
            new Point(6, 0),
            new Point(30, 18),
            new Point(18, 42),
            new Point(0, 30),
            new Point(0, 6)
        };
        
        Point[] asteroidPoints4 = {
            new Point(0, 0),
            new Point(24, 12),
            new Point(12, 36),
            new Point(6, 24),
            new Point(0, 12)
        };
        
        
        Point[] asteroidSpawnPoints = {
            new Point(100, 100),
            new Point(200, 200),
            new Point(400, 400),
            new Point(500, 500),
            new Point(600, 100),
            new Point(700, 200),
            new Point(800, 300),
            new Point(100, 500),
            new Point(200, 400),
            new Point(400, 100),
            new Point(500, 600),
            new Point(600, 300),
            new Point(700, 400),
            new Point(800, 200)
        };
        smallerAsteroidList.clear();
        explosive.clear();
        Asteroid[] array = new Asteroid[8];
        for (int i = 0; i < array.length; i++)
        {
            Point[] asteroidPoints;
            int randomSpawn = (int) (Math.random() * asteroidSpawnPoints.length);
            Point spawnPoint = asteroidSpawnPoints[randomSpawn];
            asteroidSpawnPoints[randomSpawn] = null;
            int randomIndex = (int) (Math.random() * 4);
            if (randomIndex == 0)
            {
                asteroidPoints = asteroidPoints1;
            }
            else if (randomIndex == 1)
            {
                asteroidPoints = asteroidPoints2;
            }
            else if (randomIndex == 2)
            {
                asteroidPoints = asteroidPoints3;
            }
            else if (randomIndex == 3)
            {
                asteroidPoints = asteroidPoints4;
            }
            else 
            {
                asteroidPoints = asteroidPoints1;
            }
            while (spawnPoint == null)
            {
                randomSpawn = (int) (Math.random() * asteroidSpawnPoints.length);
                spawnPoint = asteroidSpawnPoints[randomSpawn];
            }
            array[i] = new Asteroid(asteroidPoints, spawnPoint, Math.random() * 360);
            asteroidSpawnPoints[randomSpawn] = null;
        }
            // Add more asteroids here
        asteroids = new ArrayList<Asteroid>(Arrays.asList(array));
        repaint();
    }
    public void splitAsteroid(Asteroid asteroid)
    {
        Point[] smallerAsteroidPoints1 = {
            new Point(9, 0),
            new Point(18, 9),
            new Point(14, 27),
            new Point(5, 21),
            new Point(0, 9)
        };
        
        Point[] smallerAsteroidPoints2 = {
            new Point(0, 0),
            new Point(14, 5),
            new Point(10, 18),
            new Point(4, 14),
            new Point(0, 5)
        };
        int randomDir = (int) (Math.random() * 180);
        Point position1 = new Point(asteroid.getPosition().x - 10, asteroid.getPosition().y - 10);
        Point position2 = new Point(asteroid.getPosition().x + 10, asteroid.getPosition().y + 10);
        Asteroid smallerAsteroid1 = new Asteroid(smallerAsteroidPoints1, position1, randomDir);
        Asteroid smallerAsteroid2 = new Asteroid(smallerAsteroidPoints2, position2, randomDir + 180);
        // Add the smaller asteroids to the list
        smallerAsteroidList.add(smallerAsteroid1);
        smallerAsteroidList.add(smallerAsteroid2);

    }
    public void killAnimation(Asteroid asteroid)
    {
        explosive.add(new ExplosiveStar(new Point(asteroid.getPosition().x + 10, asteroid.getPosition().y), 120));
        explosive.add(new ExplosiveStar(new Point(asteroid.getPosition().x, asteroid.getPosition().y - 10), 240));
        explosive.add(new ExplosiveStar(new Point(asteroid.getPosition().x + 30, asteroid.getPosition().y), 360));
        
    }
    public void shipKillAnimation()
    {
        if (this.play)
        {
            explosive.add(new ExplosiveStar(new Point(this.ship.getPosition().x + 10, this.ship.getPosition().y), 120));
            explosive.add(new ExplosiveStar(new Point(this.ship.getPosition().x, this.ship.getPosition().y - 10), 240));
            explosive.add(new ExplosiveStar(new Point(this.ship.getPosition().x + 30, this.ship.getPosition().y), 360));
            while (!explosive.get(0).explosiveMove() && !explosive.get(1).explosiveMove() && !explosive.get(2).explosiveMove())
            {
                explosive.remove(0);
                explosive.remove(1);
                explosive.remove(2);
            }
        }
        
    }

    public void paint(Graphics brush) {
        brush.setColor(Color.black);
        brush.fillRect(0, 0, width, height);
        brush.setColor(Color.white);
        brush.setFont(new Font("Arial", Font.BOLD, 12));
        brush.drawString(Integer.toString(shipHealth) + " Heart Left", 700, 40);
        // Show the mouse position in the lower right -- useful for debugging
        java.awt.Point mousePos = this.getMousePosition();
        int xPos = mousePos != null ? mousePos.x : -1;
        int yPos = mousePos != null ? mousePos.y : -1;
        brush.setFont(getFont());
        brush.drawString("X: " + xPos + " Y: " + yPos, 700, 550);

        // Ship /////////////////////////////////////////////////////////////
        if (this.play) {
            if (turningRight) {
                ship.rotateRight();
            }
            if (turningLeft) { 
                ship.rotateLeft();
            }
            if (accelerating) {
                ship.accelerate();
            }
            ship.move();
        }
        ship.paint(brush);
        // End Ship //////////////////////////////////////////////////////////
        if (explosive != null)
        {
            for (int i = 0; i < explosive.size(); i++)
            {
                explosive.get(i).paint(brush);
                if (this.play)
                {
                    if (!explosive.get(i).explosiveMove())
                    {
                        explosive.remove(i);
                        i--;
                    }
                }
                
                
            }
        }
        // Stars /////////////////////////////////////////////////////////////
        if (this.stars != null) {
            for (Star star : stars)
            {
                if (this.play)
                {
                    star.move();
                    star.setHeading(ship.getHeading());
                }
                star.paint(brush);
            }
            // Milestone 3: Add a for loop to move (only if this.play is true) and paint each star
        }
        // End Stars /////////////////////////////////////////////////////////
        if (this.smallerAsteroidList != null)
        {
            for (Asteroid smallAsteroid : smallerAsteroidList)
            {
                if (this.play)
                {
                    smallAsteroid.move();
                }
                if (smallAsteroid.collidesWith(ship))
                {
                    if (!damageApplied)
                    {
                        shipKillAnimation();
                        shipHealth--;
                        damageApplied = true;
                        collisionTimer.start();
                    }
                    if (shipHealth <= 0)
                    {
                        this.play = false;
                        Font defaultFont = brush.getFont();
                        brush.setFont(new Font("Arial", Font.BOLD, 128));
                        brush.drawString("YOU DIED", 100, 250);
                        brush.setFont(new Font("Arial", Font.BOLD, 72));
                        brush.drawString("Press R to restart", 100,350);
                        brush.setFont(defaultFont);
                    }
                }
                smallAsteroid.paint(brush);
            }
        }
        // Asteroids /////////////////////////////////////////////////////////
        if (this.asteroids != null) {
            // Milestone 4: Add a for loop to move (only if this.play is true) and paint each asteroid
            for (Asteroid asteroid : asteroids)
            {
                if (this.play)
                {
                    asteroid.move();
                }
                if (asteroid.collidesWith(ship))
                {
                    if (!damageApplied)
                    {
                        shipKillAnimation();
                        shipHealth--;
                        damageApplied = true;
                        collisionTimer.start();
                    }
                    if (shipHealth <= 0)
                    {
                        this.play = false;
                        Font defaultFont = brush.getFont();
                        brush.setFont(new Font("Arial", Font.BOLD, 128));
                        brush.drawString("YOU DIED", 100, 250);
                        brush.setFont(new Font("Arial", Font.BOLD, 72));
                        brush.drawString("Press R to restart", 100,350);
                        brush.setFont(defaultFont);
                    }
                }
                asteroid.paint(brush);

            }
            for (int i = 0; i < asteroids.size(); i++)
            {
                if (bullet1 != null && asteroids.get(i).contains(bullet1.getPoint()))
                {
                    killAnimation(asteroids.get(i));
                    splitAsteroid(asteroids.get(i));
                    asteroids.remove(i);
                    bullet1 = null;
                    i--;
                    continue;
                }
                if (bullet2 != null && asteroids.get(i).contains(bullet2.getPoint()))
                {
                    killAnimation(asteroids.get(i));
                    splitAsteroid(asteroids.get(i));
                    asteroids.remove(i);
                    bullet2 = null;
                    i--;
                }
            }
            for (int i = 0; i < smallerAsteroidList.size(); i++)
            {
                if (bullet1 != null && smallerAsteroidList.get(i).contains(bullet1.getPoint()))
                {
                    killAnimation(smallerAsteroidList.get(i));
                    smallerAsteroidList.remove(i);
                    bullet1 = null;
                    i--;
                    continue;
                }
                if (bullet2 != null && smallerAsteroidList.get(i).contains(bullet2.getPoint()))
                {
                    killAnimation(smallerAsteroidList.get(i));
                    smallerAsteroidList.remove(i);
                    bullet2 = null;
                    i--;
                }
            }
            // Milestone 5: Add another for loop (or do it in the same loop above) that will
            // 1. Check and see if the current asteroid has collided with the ship
            // 1.2. If so, end the game (see packet for details)
            // 2. Check and see if the current asteroid "contains" bullet1 or bullet2 (after making sure that the bullet is not null)
            // 2.1. If so, set the bullet to null so it disappears, and remove the asteroid
            //      from the asteroids list (remember to adjust the loop variable accordingly)
        }
        
        Point[] thrusterPoints = { 
            new Point(0, 0), 
            new Point(-20, 10), 
            new Point(0, 20), 
            new Point(5, 10)
        };
        Polygon thurster = new Polygon(thrusterPoints, new Point(ship.getPosition().x - 20, ship.getPosition().y), ship.getHeading());
        thurster.paint(brush);
        // End Asteroids /////////////////////////////////////////////////////
        // Bullets ///////////////////////////////////////////////////////////
        if (bullet1 != null) {
            bullet1.paint(brush, 10);
            if (bullet1.bulletMove() == false) {
                bullet1 = null;
            }
        }
        if (bullet2 != null) {
            bullet2.paint(brush, 10);
            if (bullet2.bulletMove() == false) {
                bullet2 = null;
            }
        }
        // End Bullets ///////////////////////////////////////////////////////
        // Redraw the entire Canvas to apply changes made to objects
        repaint();
    }

    private void shoot() {
        if (this.play)
        {
            if (bullet1 == null) {
                bullet1 = new Bullet(new Point(ship.getPosition().x, ship.getPosition().y), ship.getHeading()); 
            } else if (bullet2 == null) {
                bullet2 = new Bullet(new Point(ship.getPosition().x, ship.getPosition().y), ship.getHeading());
            }
        }
    }

    public static void main(String[] args) {

        new Asteroids();
    }

    // Begin KeyListener
    class Keyboard implements KeyListener { 

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP && play) 
            {
                accelerating = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && play) 
            {
                turningRight = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT && play) 
            {
                turningLeft = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE && play) 
            {
                shoot();
            }
            if (e.getKeyCode() == KeyEvent.VK_R && !play)
            {

                restartGame();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) 
            {
                accelerating = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                turningRight = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                turningLeft = false;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Do not add any code here.
        }
        
    }
}