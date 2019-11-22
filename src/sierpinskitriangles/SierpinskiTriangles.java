package sierpinskitriangles;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author reganlaurell
 */

public class SierpinskiTriangles extends JPanel {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int BASE_LEVEL = 1;

    public SierpinskiTriangles(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setName("CSC 380 Graphics Problem 2 -- Regan and Joe");
        setUp();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g.create();
        
        Line2D line1 = new Line2D.Double(0.0, 200.0, 100.0, 200.0);
        Line2D line2 = new Line2D.Double(100.0, 300.0, 200.0, 300.0);
        Line2D line3 = new Line2D.Double(200.0, 400.0, 300.0, 400.0);

        drawTriangleLevel(g2, BASE_LEVEL, line1, line2, line3);
    }
    
    private void drawTriangleLevel(Graphics2D g2, int level, Line2D line1, Line2D line2, Line2D line3){
        if(level == 1){
            //base case
            Line2D line = new Line2D.Double();
           
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
