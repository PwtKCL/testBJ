import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class DrawScene here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawScene
{
    public void draw(Graphics graphics)
    {
        //draw the sky
        graphics.setColor(new Color(5, 5, 185));
        graphics.fillRect(0, 0, 600, 400);

        //draw the grass
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, 400, 600, 200);

        //draw the sun
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(500, 100, 80, 80);

        //draw the clouds
        for (int i = 0; i < 3; i += 1)
        {
            drawCloud(graphics);
        }
    }

    private void drawCloud(Graphics graphics){
        int colorUnitValue = ImageEditor.random(255);
        graphics.setColor(new Color(colorUnitValue, colorUnitValue, colorUnitValue));
        
        int numberOfCloudParts = 2 + ImageEditor.random(10);
        int firstCloudPartX = ImageEditor.random(600);
        int firstCloudPartY = ImageEditor.random(400);
        for(int i = 0; i < numberOfCloudParts; i++){
            graphics.fillOval(firstCloudPartX + ImageEditor.random(50), firstCloudPartY + ImageEditor.random(20), 60, 20);
        }
    }
}
