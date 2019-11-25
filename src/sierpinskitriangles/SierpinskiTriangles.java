package sierpinskitriangles;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author reganlaurell
 * references: https://courses.cs.washington.edu/courses/cse143/19sp/lectures/Sierpinski.java
 */

public class SierpinskiTriangles extends JPanel implements KeyListener{
    private static final int SIZE = 1000;
    
    private int intialLevel = 1;
    private int triangleHeight = (int) Math.round(SIZE * Math.sqrt(3.0) / 2.0); 
    
    private Point2D pointOne = new Point(0, triangleHeight);
    private Point2D pointTwo = new Point(SIZE / 2, 0);
    private Point2D pointThree = new Point(SIZE, triangleHeight);
    
    private boolean whiteBackground = true;
    
    public SierpinskiTriangles(){
        setPreferredSize(new Dimension(SIZE, SIZE));
        setName("CSC 380 Graphics Project 2 -- Regan and Joe");
        setUp();
        setBackground(Color.WHITE);
        
        addKeyListener(this);
        requestFocusInWindow();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g.create();
        
        drawTriangleLevel(g2, intialLevel, pointOne, pointTwo, pointThree);
    }
    
    public void drawTriangleLevel(Graphics2D g2, int level, Point2D p1, Point2D p2, Point2D p3){
        if(level == 1){
           //base case
           Polygon poly = new Polygon();
           poly.addPoint((int) p1.getX(), (int) p1.getY());
           poly.addPoint((int) p2.getX(), (int) p2.getY());
           poly.addPoint((int) p3.getX(), (int) p3.getY());
           
           Color randomColor = whiteBackground ? getRandomColorForWhiteBackground() : getRandomColorForBlackBackground();
           g2.setPaint(randomColor);
           g2.setStroke(new BasicStroke(2));
           g2.draw(poly);
        }else{
            //recursive case
            Point2D p4 = midpoint(p1, p2);
            Point2D p5 = midpoint(p2, p3);
            Point2D p6 = midpoint(p1, p3);
            
            drawTriangleLevel(g2, level - 1, p1, p4, p6);
            drawTriangleLevel(g2, level - 1, p4, p2, p5);
            drawTriangleLevel(g2, level - 1, p6, p5, p3);
        }
    }
    
    private Color getRandomColorForWhiteBackground(){
        Random random = new Random();
        int red = random.nextInt(225);
        int blue = random.nextInt(225);
        int green = random.nextInt(225);
        
        return new Color(red, green, blue);
    }
    
    private Color getRandomColorForBlackBackground(){
        Random random = new Random();
        int red = random.nextInt(225) + 30;
        int blue = random.nextInt(225) + 30;
        int green = random.nextInt(225) + 30;
        
        return new Color(red, green, blue);
    }
    
    private Point2D midpoint(Point2D a, Point2D b){
        double aX = a.getX();
        double aY = a.getY();
        double bX = b.getX();
        double bY = b.getY();
        
        double midX = (aX + bX) / 2;
        double midY = (aY + bY) / 2;
        Point2D midpoint = new Point2D.Double(midX, midY);

        return midpoint;
    }
    
    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();
        Graphics2D graphics = (Graphics2D) getGraphics();

        switch (key) {
            case KeyEvent.VK_UP: 
                if(intialLevel <= 10){
                    repaint();
                    intialLevel += 1;
                    drawTriangleLevel(graphics, intialLevel, pointOne, pointTwo, pointThree);
                    System.out.println(intialLevel);
                }
                break;
            case KeyEvent.VK_DOWN: 
                if(intialLevel > 1) {
                    repaint();
                    intialLevel -= 1;                          
                    drawTriangleLevel(graphics, intialLevel, pointOne, pointTwo, pointThree);
                    System.out.println(intialLevel);                          
                }
                break;
        }
    }
    
    public void keyReleased(KeyEvent evt) {}
    
    public void keyTyped(KeyEvent evt) {
        char ch = evt.getKeyChar();
        
        switch (Character.toLowerCase(ch)) {
            case 'b':
                whiteBackground = !whiteBackground;
                
                if (whiteBackground) 
                    setBackground(Color.WHITE);
                else 
                    setBackground(Color.BLACK);
                
                repaint();
                break;
            case 'q': System.exit(0);
        }
    } 

    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void setUp() {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);    
    }
    
    public static void main(String[] args) {new SierpinskiTriangles();}
}