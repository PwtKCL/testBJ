import java.awt.Graphics;

/**
 * Write a description of interface DrawingTool here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface DrawingTool
{
    public default void mousePressed(Graphics graphics, int x, int y)
    {
    }
    
    public default void mouseReleased(Graphics graphics, int x, int y)
    {
    }
    
    public default void mouseDragged(Graphics graphics, int x, int y)
    {
    }
}
