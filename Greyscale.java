import java.awt.Color;
/**
 * Write a description of class Greyscale here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Greyscale implements PerPixelFilter
{
    public Color applyFilter(Color source)
    {
        int colorAverage = (source.getRed() + source.getBlue() + source.getGreen())/3; 
        return new Color(colorAverage, colorAverage, colorAverage);
    }
}
