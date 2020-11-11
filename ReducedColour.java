import java.awt.Color;

/**
 * Write a description of class ReducedFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReducedColour implements PerPixelFilter
{
    public Color applyFilter(Color source)
    {
        int colorRed = (source.getRed() > 127) ? 255 : 0;
        int colorGreen = (source.getGreen() > 127) ? 255 : 0;
        int colorBlue = (source.getBlue() > 127) ? 255 : 0;

        return new Color(colorRed, colorGreen, colorBlue);
    }
}
