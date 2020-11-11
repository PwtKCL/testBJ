import java.awt.Graphics;

/**
 * Write a description of class Pen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pen implements DrawingTool
{
    private int lastX, lastY;
    
    public void mousePressed(Graphics graphics, int x, int y)
    {
        lastX = x;
        lastY = y;
    }
    
    public void mouseDragged(Graphics graphics, int x, int y)
    {
        graphics.drawLine(lastX, lastY, x, y);
        lastX = x;
        lastY = y;
    }
}