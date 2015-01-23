
/**
 * Write a description of class PhotoContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class PhotoContainer extends JPanel
{
    private BufferedImage imageToPaint = null;
    /**
     * Constructor for objects of class PhotoContainer
     */
    public PhotoContainer()
    {

    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.clearRect(0,0,this.getWidth(),this.getHeight());
        try{
            g.drawImage(imageToPaint, this.getWidth()/2 - imageToPaint.getWidth()/2, this.getHeight()/2 - imageToPaint.getHeight()/2, null);
        }catch(Exception e) {
            System.out.println(e.toString());
        }
        
    }
    
    public void setImage(BufferedImage img)
    {
        imageToPaint = img;
        repaint();
    }
}
