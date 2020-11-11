import java.awt.Color;

/**
 * Write a description of class Darken here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Darken implements PerPixelFilter
{
    public Color applyFilter(Color source)
    {
        int colorRed = source.getRed() - 15;
        int colorGreen = source.getGreen() - 15;
        int colorBlue = source.getBlue() - 15;

        if(colorRed < 0)
            colorRed = 0;
        if(colorGreen < 0)
            colorGreen = 0;
        if(colorBlue < 0)
            colorBlue = 0;
        return new Color(colorRed, colorGreen, colorBlue);
    }
}
