import java.awt.Color;

/**
 * Write a description of class InvertColour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sepia implements PerPixelFilter
{
    public Color applyFilter(Color source)
    {
        int colorRed = Math.round((source.getRed() * 0.393f) + (source.getGreen() * 0.769f) + (source.getBlue() * 0.189f));
        int colorGreen = Math.round((source.getRed() * 0.349f) + (source.getGreen() * 0.686f) + (source.getBlue() * 0.168f));
        int colorBlue = Math.round((source.getRed() * 0.272f) + (source.getGreen() * 0.534f) + (source.getBlue() * 0.131f));
        
        if(colorRed > 255)
            colorRed = 255;
        if(colorGreen > 255)
            colorGreen = 255;
        if(colorBlue > 255)
            colorBlue = 255;
            
        return new Color(colorRed, colorGreen, colorBlue);
    }
}
