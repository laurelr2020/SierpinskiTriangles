package sierpinskitriangles;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author reganlaurell
 */

public class SierpinskiTriangles extends JPanel {
    private static final int SIZE = 1000;
    private static final int BASE_LEVEL = 1;

    public SierpinskiTriangles(){
        setPreferredSize(new Dimension(SIZE, SIZE));
        setName("CSC 380 Graphics Problem 2 -- Regan and Joe");
        setUp();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g.create();
        
        int triangleHeight = (int) Math.round(SIZE * Math.sqrt(3.0) / 2.0); 
        Point2D pointOne = new Point(0, triangleHeight);
        Point2D pointTwo = new Point(SIZE / 2, 0);
        Point2D pointThree = new Point(SIZE, triangleHeight);
        
        drawTriangleLevel(g2, BASE_LEVEL, pointOne, pointTwo, pointThree);
    }
    
    private void drawTriangleLevel(Graphics2D g2, int level, Point2D p1, Point2D p2, Point2D p3){
        if(level == 1){
           //base case
           Polygon poly = new Polygon();
           poly.addPoint((int) p1.getX(), (int) p1.getY());
           poly.addPoint((int) p2.getX(), (int) p2.getY());
           poly.addPoint((int) p3.getX(), (int) p3.getY());
           
           g2.setPaint(Color.BLUE);
           g2.setStroke(new BasicStroke(2));
           g2.fill(poly);
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
