import java.awt.Color;

/**
 * Write a description of class Ligthen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lighten implements PerPixelFilter
{
    public Color applyFilter(Color source)
    {
        int colorRed = source.getRed() + 15;
        int colorGreen = source.getGreen() + 15;
        int colorBlue = source.getBlue() + 15;

        if(colorRed > 255)
            colorRed = 255;
        if(colorGreen > 255)
            colorGreen = 255;
        if(colorBlue > 255)
            colorBlue = 255;
        return new Color(colorRed, colorGreen, colorBlue);
    }
}
