package sierpinskitriangles;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author reganlaurell
 */

public class SierpinskiTriangles extends JPanel {
    public static final int SIZE = 600;  // height/width of DrawingPanel

    public SierpinskiTriangles(){
        setPreferredSize(new Dimension(SIZE, SIZE));
        setName("CSC 380 Graphics Problem 2 -- Regan and Joe");
        setUp();
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g.create();


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
