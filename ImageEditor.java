import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.util.Random;
import java.awt.Graphics;

/**
 * Write a description of class ImageEditor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImageEditor extends MouseInputAdapter
{
    private final JFrame frame;
    private final BufferedImage image;
    private DrawingTool tool = new Pen();
    private int startX = 0, startY = 0;

    private ImageEditor()
    {
        this.frame = new JFrame();
        image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        JLabel imageDisplay = new JLabel(new ImageIcon(image));
        imageDisplay.addMouseListener(this);
        imageDisplay.addMouseMotionListener(this);
        frame.getContentPane().add(imageDisplay, BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(makeFilterMenu());
        frame.setJMenuBar(menuBar);
        frame.pack();
        initialiseImage();
    }

    private void initialiseImage()
    {
        image.getGraphics().setColor(Color.WHITE);
        image.getGraphics().fillRect(0, 0, image.getWidth(), image.getHeight());
        //new DrawScene().draw(image.getGraphics());
    }

    private JMenu makeFilterMenu()
    {
        JMenu menu = new JMenu("Filters");
        menu.add(makeFilterMenuItem("Darken", new Darken()));
        menu.add(makeFilterMenuItem("Lighten", new Lighten()));
        menu.add(makeFilterMenuItem("Convert to grey", new Greyscale()));
        menu.add(makeFilterMenuItem("Convert to reduced colours", new ReducedColour()));
        menu.add(makeFilterMenuItem("Invert colours", new InvertColour()));
        menu.add(makeFilterMenuItem("Convert to sepia", new Sepia()));
        return menu;
    }

    private JMenuItem makeFilterMenuItem(String name, PerPixelFilter filter)
    {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(e -> applyFilter(filter));
        return menuItem;
    }

    private void applyFilter(PerPixelFilter filter)
    {
        for (int y = 0; y < image.getHeight(); y++)
        {
            for (int x = 0; x < image.getWidth(); x++)
            {
                image.setRGB(x, y, filter.applyFilter(new Color(image.getRGB(x, y))).getRGB());
            }
        }
        frame.repaint();
    }

    public void mousePressed(MouseEvent e)
    {
        if (tool != null)
        {
            tool.mousePressed(getGraphics(), e.getX(), e.getY());
            tool.mouseDragged(getGraphics(), e.getX(), e.getY());
            frame.repaint();
        }
        startX = e.getX();
        startY = e.getY();
    }

    public void mouseReleased(MouseEvent e)
    {
        if (tool != null)
        {
            tool.mouseReleased(getGraphics(), e.getX(), e.getY());
            frame.repaint();
        }
        else{
            Graphics g = getGraphics();
            g.setColor(Color.BLACK);
            int topLeftX = (startX > e.getX()) ? e.getX() : startX;
            int topLeftY = (startY > e.getY()) ? e.getY() : startY;
            g.fillRect(topLeftX, topLeftY, Math.abs(e.getX() - startX), Math.abs(e.getY() - startY));
            frame.repaint();
        }
    }

    public void mouseDragged(MouseEvent e)
    {
        if (tool != null)
        {
            tool.mouseDragged(getGraphics(), e.getX(), e.getY());
            frame.repaint();
        }
    }

    private Graphics2D getGraphics()
    {
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.BLACK);
        return graphics;
    }

    public static void show()
    {
        new ImageEditor().frame.setVisible(true);
    }

    protected static int random(int limit)
    {
        return new Random().nextInt(limit);
    }
}
