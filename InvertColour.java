import java.awt.Color;

/**
 * Write a description of class InvertColour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InvertColour implements PerPixelFilter
{
    public Color applyFilter(Color source)
    {
        int colorRed = 255 - source.getRed();
        int colorGreen = 255 - source.getGreen();
        int colorBlue = 255 - source.getBlue();

        return new Color(colorRed, colorGreen, colorBlue);
    }
}
